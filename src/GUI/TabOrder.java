package GUI;

import csv.readCSV;
import csv.writeCSV;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import supportClass.Order;
import supportClass.Product;

import java.util.ArrayList;

import static GUI.Main.*;
import static GUI.TabStatistics.PRODUCT_DATA_DIR;
import static supportClass.Product.*;
import static supportClass.Product.OUTPUTDATE_INDEX;
import static supportClass.Product.TOTAL_ATTRIBUTES;

public class TabOrder {
    //------------------------------------------------------
    // PROPERTIES
    //------------------------------------------------------

    private final String ORDER_FILE = "src/database/orders.csv";

    private static final int ID_SPACE = 80;
    private static final int NAME_SPACE = 150;
    private static final int QTY_SPACE = 50;
    private static final int DESC_SPACE = 250;
    private static final int PRODUCER_SPACE = 100;
    private static final int DEFAULT_SPACE = 100;
    private static final int BUTTON_SPACE = 100;

    private VBox tabOrder;
    private VBox boxOrder;
    private Label tabTitle, noOrder;

    private GridPane newItemLayout;
    private Label newItemLabel1, newItemLabel2, newItemLabel3;
    private TextField[] textFields;
    private Button addButton;

    private ArrayList<Order> orders;

    public TabOrder() {
        tabOrder = new VBox();
        boxOrder = new VBox();
        tabTitle = new Label("ORDERS");
        noOrder = new Label(NO_ORDER);
        newItemLayout = new GridPane();
        textFields = new TextField[TOTAL_ATTRIBUTES];

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

        settingAddNew();

        tabOrder.setMinSize(WIDTH - TAB_WIDTH, HEIGHT - TITLE_BAR_HEIGHT);
        tabOrder.setSpacing(SPACING);
        tabOrder.setPadding(new Insets(SPACING, SPACING, SPACING, SPACING * 2));

        return tabOrder;
    }

    private void updateTabOrder() {
        tabOrder.getChildren().clear();

        if (boxOrder.getChildren().isEmpty())
            tabOrder.getChildren().addAll(tabTitle, noOrder, newItemLayout);
        else
            tabOrder.getChildren().addAll(tabTitle, boxOrder, newItemLayout);
    }

    //---------------------NEWITEMLAYOUT METHODS---------------------
    private void addButtonClicked() {
        Product product = new Product();

        product.setId(textFields[ID_INDEX].getText());
        product.setName(textFields[NAME_INDEX].getText());
        product.setQty(Integer.parseInt(textFields[QTY_INDEX].getText()));
        product.setDesc(textFields[DESC_INDEX].getText());
        product.setProducer(textFields[PRODUCER_INDEX].getText());
        product.setLocation(textFields[LOCATION_INDEX].getText());
        product.setStatus(textFields[STATUS_INDEX].getText());
        product.setInputDate(textFields[INPUTDATE_INDEX].getText());
        product.setOutputDate(textFields[OUTPUTDATE_INDEX].getText());

        writeCSV.writeData(PRODUCT_DATA_DIR, product);

        for(int i = 0; i < TOTAL_ATTRIBUTES; i++)
            textFields[i].clear();
    }

    private TextField addTextField (String hint, int width) {
        TextField textField = new TextField();
        textField.setPromptText(hint);
        textField.setPrefWidth(width);
        return textField;
    }

    private void settingAddNew() {
        newItemLayout.setPadding(new Insets(SPACING/2, SPACING/2, SPACING/2, SPACING/2));
        newItemLayout.setVgap(SPACING/4);
        newItemLayout.setHgap(SPACING/2);

        //label "Prodduct Details"
        newItemLabel1 = new Label ("Product Details");
        GridPane.setConstraints(newItemLabel1, 0, 0);
        //textFields (id - name - qty - desc - producer)
        textFields[ID_INDEX] = addTextField(PRODUCT_LABEL[ID_INDEX], ID_SPACE);
        textFields[NAME_INDEX] = addTextField(PRODUCT_LABEL[NAME_INDEX], NAME_SPACE);
        textFields[QTY_INDEX] = addTextField(PRODUCT_LABEL[QTY_INDEX], DEFAULT_SPACE);
        textFields[DESC_INDEX] = addTextField(PRODUCT_LABEL[DESC_INDEX], DESC_SPACE);
        textFields[PRODUCER_INDEX] = addTextField(PRODUCT_LABEL[PRODUCER_INDEX], PRODUCER_SPACE);

        GridPane.setConstraints(textFields[ID_INDEX], 1, 0);
        GridPane.setConstraints(textFields[NAME_INDEX], 2, 0);
        GridPane.setConstraints(textFields[QTY_INDEX], 3, 0);
        GridPane.setConstraints(textFields[DESC_INDEX], 4, 0);
        GridPane.setConstraints(textFields[PRODUCER_INDEX], 5, 0);

        //label "Location/Status"
        newItemLabel2 = new Label ("Location/Status");
        GridPane.setConstraints(newItemLabel2, 0, 1);
        //textFields (location - status)
        textFields[LOCATION_INDEX] = addTextField(PRODUCT_LABEL[LOCATION_INDEX], DEFAULT_SPACE);
        textFields[STATUS_INDEX] = addTextField(PRODUCT_LABEL[STATUS_INDEX], DEFAULT_SPACE);

        GridPane.setConstraints(textFields[LOCATION_INDEX], 1, 1);
        GridPane.setConstraints(textFields[STATUS_INDEX], 2, 1);

        //label "Date"
        newItemLabel3 = new Label ("Date");
        GridPane.setConstraints(newItemLabel3, 0, 2);
        //textFields (inputdate - outputdate)
        textFields[INPUTDATE_INDEX] = addTextField(PRODUCT_LABEL[INPUTDATE_INDEX], DEFAULT_SPACE);
        textFields[OUTPUTDATE_INDEX] = addTextField(PRODUCT_LABEL[OUTPUTDATE_INDEX], DEFAULT_SPACE);

        GridPane.setConstraints(textFields[INPUTDATE_INDEX], 1, 2);
        GridPane.setConstraints(textFields[OUTPUTDATE_INDEX], 2, 2);

        //add button
        addButton = new Button("Add");
        addButton.setPrefWidth(BUTTON_SPACE);
        addButton.setAlignment(Pos.CENTER);
        addButton.setOnAction(e -> addButtonClicked());
        GridPane.setConstraints(addButton, 5, 1);

        //add elements
        newItemLayout.getChildren().addAll(newItemLabel1, newItemLabel2, newItemLabel3, addButton);
        for (int i = 0; i < TOTAL_ATTRIBUTES; i++)
            newItemLayout.getChildren().addAll(textFields[i]);
    }
}