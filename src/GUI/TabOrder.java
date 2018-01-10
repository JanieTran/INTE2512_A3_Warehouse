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
    private Label tabTitle;
    private Order kabylake;
    private GridPane gpOrder;

    private ArrayList<Order> orders;

    public TabOrder() {
        tabOrder = new VBox();
        boxOrder = new VBox();
        tabTitle = new Label("ORDERS");
//        kabylake = new Order("KABYLAKE", "ABC2345", 1000, "Intel", "input");
//        gpOrder = kabylake.getGridOrder();
        orders = readCSV.readCSVtoOrder(ORDER_FILE);
    }

    public VBox getTabOrder() {
        tabOrder.getChildren().clear();
        boxOrder.getChildren().clear();

        for (Order order : orders) {
            GridPane gridOrder = order.getGridOrder();
            boxOrder.getChildren().add(gridOrder);
        }

        boxOrder.setSpacing(SPACING);

        tabTitle.setFont(Font.font(30));
        tabTitle.setStyle("-fx-font-weight: bold; -fx-text-fill: #2196f3");

        tabOrder.getChildren().addAll(tabTitle, boxOrder);
        tabOrder.setMinSize(WIDTH - TAB_WIDTH, HEIGHT - TITLE_BAR_HEIGHT);
        tabOrder.setSpacing(SPACING);
        tabOrder.setPadding(new Insets(SPACING, SPACING, SPACING, SPACING * 2));

        return tabOrder;
    }
}
