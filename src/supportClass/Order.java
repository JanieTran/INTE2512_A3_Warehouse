package supportClass;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.sql.Timestamp;

import static GUI.Main.SPACING;
import static GUI.Main.fetchImg;

public class Order {
    private Product product;
    private boolean input;
    private boolean expanded;

    private GridPane gridOrder;
    private ImageView icon;
    private Button accept, decline;
    private Label productID, timestamp, producer, quantity, productName;

    public Order() {
        product = new Product();
        input = true;
        accept = new Button("Accept");
        decline = new Button("Decline");
        gridOrder = new GridPane();
    }

    public Order(String name, String id, int qty, String producer, boolean input) {
        this.product = new Product(name, id, qty);
        product.setProducer(producer);

        gridOrder = new GridPane();
        productID = new Label(product.getId());
        timestamp = new Label(new Timestamp(System.currentTimeMillis()).toString());
        productName = new Label("Product: " + product.getName());
        this.producer = new Label("From: " + product.getProducer());
        quantity = new Label("Quantity: " + product.getQty());

        accept = new Button("Accept");
        decline = new Button("Decline");

        if (input)
            icon = new ImageView(fetchImg("ic_receiver.png"));
        else
            icon = new ImageView(fetchImg("ic_deliver.png"));

        expanded = false;
    }

    public GridPane getGridOrder() {
        productID.setStyle("-fx-font-weight: bold");
        productID.setFont(Font.font(20));
        productID.setMinWidth(600);
        productID.setPadding(new Insets(0,SPACING,0,SPACING));

        timestamp.setFont(Font.font(15));
        timestamp.setMinWidth(600);
        timestamp.setPadding(new Insets(0,SPACING,0,SPACING));

        productName.setFont(Font.font(15));
        productName.setStyle("-fx-font-style: italic");
        productName.setPadding(new Insets(0, SPACING, 0, SPACING));

        quantity.setFont(Font.font(15));
        quantity.setStyle("-fx-font-style: italic");
        quantity.setPadding(new Insets(0, SPACING, 0, SPACING));

        producer.setFont(Font.font(15));
        producer.setStyle("-fx-font-style: italic");
        producer.setPadding(new Insets(0, SPACING, 0, SPACING));

        accept.setStyle("-fx-background-color: #00e676");
        accept.setPadding(new Insets(SPACING, SPACING, SPACING, SPACING));

        decline.setStyle("-fx-background-color: #ff1744; -fx-text-fill: #ffffff");
        decline.setPadding(new Insets(SPACING, SPACING, SPACING, SPACING));

        gridCollapse();

        gridOrder.setOnMouseClicked(event -> {
            if (expanded)
                gridCollapse();
            else
                gridExpand();

            expanded = !expanded;
        });

        gridOrder.setPadding(new Insets(0,0,0,SPACING * 2));
        gridOrder.setStyle("-fx-background-color: #e0e0e0");

        return gridOrder;
    }

    private void gridCollapse() {
        gridOrder.getChildren().clear();

        gridOrder.add(icon, 0, 0, 1, 2);
        gridOrder.add(productID, 1, 0, 1, 1);
        gridOrder.add(timestamp, 1, 1, 1, 1);
        gridOrder.add(accept, 2, 0, 1, 2);
        gridOrder.add(decline, 3, 0, 1, 2);
    }

    private void gridExpand() {
        gridCollapse();

        gridOrder.add(productName, 1, 2, 1, 1);
        gridOrder.add(quantity, 1, 3, 1, 1);
        gridOrder.add(producer, 1, 4, 1, 1);
    }
}