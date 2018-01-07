package GUI;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import product.Product;

import java.sql.Timestamp;

import static GUI.Main.SPACING;
import static GUI.Main.fetchImg;

public class Order {
    private Product product;
    private boolean input;

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
    }

    public GridPane getGridOrder() {
        productID.setStyle("-fx-font-weight: bold");
        productID.setFont(Font.font(20));
        productID.setPadding(new Insets(0,SPACING,0,SPACING));

        timestamp.setFont(Font.font(20));
        timestamp.setPadding(new Insets(0,SPACING,0,SPACING));

        accept.setStyle("-fx-background-color: #00e676");
        accept.setPadding(new Insets(SPACING, SPACING, SPACING, SPACING));

        decline.setStyle("-fx-background-color: #ff1744; -fx-text-fill: #ffffff");
        decline.setPadding(new Insets(SPACING, SPACING, SPACING, SPACING));

        gridOrder.add(icon, 0, 0, 1, 2);
        gridOrder.add(productID, 1, 0, 1, 1);
        gridOrder.add(timestamp, 1, 1, 1, 1);
        gridOrder.add(accept, 2, 0, 1, 2);
        gridOrder.add(decline, 3, 0, 1, 2);

        gridOrder.setPadding(new Insets(0,0,0,SPACING * 2));
        gridOrder.setStyle("-fx-background-color: #bbdefb");

        return gridOrder;
    }
}