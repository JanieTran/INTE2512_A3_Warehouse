package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import supportClass.Product;
import javafx.scene.layout.VBox;
import csv.writeCSV;

import static GUI.Main.*;
import static supportClass.Product.*;


public class TabStatistics {
    //--------------------CONSTANTS--------------------
    private static final int ID_SPACE = 80;
    private static final int NAME_SPACE = 150;
    private static final int QTY_SPACE = 50;
    private static final int DESC_SPACE = 250;
    private static final int PRODUCER_SPACE = 100;
    private static final int DEFAULT_SPACE = 100;
    private static final int BUTTON_SPACE = 100;

    //--------------------TAB PROPERTIES--------------------
    private VBox tabStatistics;
    private Label tabTitle;
    private TableView<Product> table;
    private TableColumn<Product, String>[] columns;
    private GridPane newItemLayout;
    private Label newItemLabel1, newItemLabel2, newItemLabel3;
    private HBox newItemTextField;
    private TextField[] textFields;
    private Button addButton, deleteButton;

    public TabStatistics() {
        tabStatistics = new VBox();
        tabTitle = new Label("STATISTICS");
        table = new TableView<>();
        newItemLayout = new GridPane();
        textFields = new TextField[TOTAL_ATTRIBUTES];
    }

    public VBox getTabStatistics() {
        tabStatistics.getChildren().clear();

        //---------------------CUSTOM tabTitle---------------------
        tabTitle.setFont(Font.font(30));
        tabTitle.setStyle("-fx-font-weight: bold; -fx-text-fill: #2196f3");

        //---------------------CUSTOM table---------------------
        //add columns for product properties
        columns = new TableColumn[TOTAL_ATTRIBUTES];
        for (int i = 0; i < TOTAL_ATTRIBUTES; i++) {
            int colMinWidth;

            switch (i) {
                case ID_INDEX: colMinWidth = ID_SPACE; break;
                case NAME_SPACE: colMinWidth = NAME_SPACE; break;
                case QTY_INDEX: colMinWidth = QTY_SPACE; break;
                case DESC_INDEX: colMinWidth = DESC_SPACE; break;
                case PRODUCER_INDEX: colMinWidth = PRODUCER_SPACE; break;
                default: colMinWidth = DEFAULT_SPACE;
            }
            columns[i] = addStringColumn(PRODUCT_LABEL[i], colMinWidth, PRODUCT_PROPERTIES[i]);
        }
//        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setItems(getProduct());
        table.getColumns().addAll(columns);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        //---------------------CUSTOM newItemLayout---------------------
        newItemLayout.setPadding(new Insets(SPACING/2, SPACING/2, SPACING/2, SPACING/2));
        newItemLayout.setVgap(SPACING/4);
        newItemLayout.setHgap(SPACING/2);
        //newItemLabel - Product Details
        newItemLabel1 = new Label ("Product Details");
        GridPane.setConstraints(newItemLabel1, 0, 0);

        //add textFields
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

        //newItemLabel2 - Location/Status
        newItemLabel2 = new Label ("Location/Status");
        GridPane.setConstraints(newItemLabel2, 0, 1);
        //add textFields
        textFields[LOCATION_INDEX] = addTextField(PRODUCT_LABEL[LOCATION_INDEX], DEFAULT_SPACE);
        textFields[STATUS_INDEX] = addTextField(PRODUCT_LABEL[STATUS_INDEX], DEFAULT_SPACE);

        GridPane.setConstraints(textFields[LOCATION_INDEX], 1, 1);
        GridPane.setConstraints(textFields[STATUS_INDEX], 2, 1);

        //newItemLabel3 - Date
        newItemLabel3 = new Label ("Date");
        GridPane.setConstraints(newItemLabel3, 0, 2);
        //add textFields
        textFields[INPUTDATE_INDEX] = addTextField(PRODUCT_LABEL[INPUTDATE_INDEX], DEFAULT_SPACE);
        textFields[OUTPUDATE_INDEX] = addTextField(PRODUCT_LABEL[OUTPUDATE_INDEX], DEFAULT_SPACE);

        GridPane.setConstraints(textFields[INPUTDATE_INDEX], 1, 2);
        GridPane.setConstraints(textFields[OUTPUDATE_INDEX], 2, 2);

        //add Add/Delete button
        addButton = new Button("Add");
        addButton.setPrefWidth(BUTTON_SPACE);
        addButton.setAlignment(Pos.CENTER);
        addButton.setOnAction(e -> addButtonClicked());
        GridPane.setConstraints(addButton, 5, 1);

        deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());
        deleteButton.setPrefWidth(BUTTON_SPACE);
        deleteButton.setAlignment(Pos.CENTER);
        GridPane.setConstraints(deleteButton, 5, 2);

        //add elements
        newItemLayout.getChildren().addAll(newItemLabel1, newItemLabel2, newItemLabel3, addButton, deleteButton);
        for (int i = 0; i < TOTAL_ATTRIBUTES; i++)
            newItemLayout.getChildren().addAll(textFields[i]);

        //---------------------CUSTOM tabStatistics---------------------
        tabStatistics.setMinSize(WIDTH - TAB_WIDTH, HEIGHT - TITLE_BAR_HEIGHT);
        tabStatistics.setSpacing(SPACING);
        tabStatistics.setPadding(new Insets(SPACING, SPACING, SPACING, SPACING));
        tabStatistics.getChildren().addAll(tabTitle, table, newItemLayout);

        return tabStatistics;
    }

    //---------------------TABLE METHODS---------------------
    private ObservableList<Product> getProduct() {
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("KABY LAKE", "ABC2345", 1000));
        products.add(new Product("SAMSUNG NOTE 8", "SSN2345", 2000));
        products.add(new Product("IPHONE X", "IPX2345", 500));
        return products;
    }

    private TableColumn<Product, String> addStringColumn(String colName, int minWidth, String propertyValue) {
        TableColumn<Product, String> column = new TableColumn<>(colName);
        column.setMinWidth(minWidth);
        column.setCellValueFactory(new PropertyValueFactory<>(propertyValue));
        return column;
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

        table.getItems().add(product);
        writeCSV.writeData("file:src/data.csv", product);

        for(int i = 0; i < TOTAL_ATTRIBUTES; i++)
            textFields[i].clear();
    }

    private void deleteButtonClicked() {
        ObservableList<Product> productsSelected, allProducts;
        allProducts = table.getItems();
        productsSelected = table.getSelectionModel().getSelectedItems();
        allProducts.removeAll(productsSelected);
    }

    private TextField addTextField (String hint, int width) {
        TextField textField = new TextField();
        textField.setPromptText(hint);
        textField.setPrefWidth(width);
        return textField;
    }
}
