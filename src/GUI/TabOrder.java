package GUI;

import csv.readCSV;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import supportClass.Order;

import java.util.ArrayList;

import static GUI.Main.*;

public class TabOrder {
    //------------------------------------------------------
    // PROPERTIES
    //------------------------------------------------------

    private final String ORDER_FILE = "src/database/orders.csv";

    private VBox tabOrder;
    private VBox boxOrder;
    private Label tabTitle, noOrder;

    private ArrayList<Order> orders;

    public TabOrder() {
        tabOrder = new VBox();
        boxOrder = new VBox();
        tabTitle = new Label("ORDERS");
        noOrder = new Label(NO_ORDER);
        orders = readCSV.readCSVtoOrder(ORDER_FILE);
    }

    public VBox getTabOrder() {
        tabOrder.getChildren().clear();
        boxOrder.getChildren().clear();

        for (Order order : orders) {
            GridPane gridOrder = order.getGridOrder();
            boxOrder.getChildren().add(gridOrder);

            order.getAccept().setOnMouseClicked(event -> {
                boxOrder.getChildren().remove(gridOrder);
                updateTabOrder();
            });

            order.getDecline().setOnMouseClicked(event -> {
                boxOrder.getChildren().remove(gridOrder);
                updateTabOrder();
            });
        }

        updateTabOrder();

        boxOrder.setSpacing(SPACING);

        tabTitle.setFont(Font.font(30));
        tabTitle.setStyle("-fx-font-weight: bold; -fx-text-fill: #2196f3");

        noOrder.setFont(Font.font(20));
        noOrder.setPadding(new Insets(SPACING, SPACING, SPACING, SPACING * 2));
        noOrder.setStyle("-fx-text-fill: #ababab");

        tabOrder.setMinSize(WIDTH - TAB_WIDTH, HEIGHT - TITLE_BAR_HEIGHT);
        tabOrder.setSpacing(SPACING);
        tabOrder.setPadding(new Insets(SPACING, SPACING, SPACING, SPACING * 2));

        return tabOrder;
    }

    private void updateTabOrder() {
        tabOrder.getChildren().clear();

        if (boxOrder.getChildren().isEmpty())
            tabOrder.getChildren().addAll(tabTitle, noOrder);
        else
            tabOrder.getChildren().addAll(tabTitle, boxOrder);
    }
}
