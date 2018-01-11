package GUI;

import csv.readCSV;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import supportClass.Product;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

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

    private final String SEARCH_BY_NAME = "Search product name";
    public static final String PRODUCT_DATA_DIR = "src/database/product.csv";
    public final static String ORDER_DATA_DIR = "src/database/orders.csv";
    private static final String TAB_NAME = "STATISTICS";

    //--------------------TAB PROPERTIES--------------------
    private VBox tabStatistics;
    private Label tabTitle;
    private TableView<Product> table;
    private TableColumn<Product, String>[] columns;
    private TextField txtSearch;
    private Button searchButton;
    private HBox hbSearch;
    private Image productImg;
    private ImageView productImgView;

    private ArrayList<Product> productList;

    public TabStatistics() {
        tabStatistics = new VBox();
        tabTitle = new Label(TAB_NAME);
        table = new TableView<>();
        txtSearch = new TextField();
        searchButton = new Button("Search");
        hbSearch = new HBox();
        productImgView = new ImageView();
    }

    public VBox getTabStatistics() {
        // Each time this method is called, the contents is refreshed to avoid duplicating children
        tabStatistics.getChildren().clear();
        table.getColumns().clear();

        //---------------------CUSTOM tabTitle------------------
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

<<<<<<< HEAD
=======

>>>>>>> 8158159f41dd68fb02733886e6a5800da44c2284
        table.setItems(getProduct());
        table.getColumns().addAll(columns);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // When a row in the table is clicked, the ImageView is updated with the corresponding image
        table.setOnMouseClicked(event -> {
            Product product = table.getSelectionModel().getSelectedItem();
            productImg = new Image(product.getImage());
            LoginLayout.createImageView(productImgView, productImg, 100, 100);

            // Update tab to see changes in image view
            updateTab();
        });

        // Display hint text in text field
        txtSearch.setPromptText(SEARCH_BY_NAME);

        // Box containing elements of search feature
        hbSearch.getChildren().clear();
        hbSearch.getChildren().addAll(txtSearch, searchButton);
        hbSearch.setSpacing(SPACING);

        // When search button is clicked, the table shows results that matches the query
        searchButton.setOnMouseClicked(event -> {
            table.getItems().clear();
            table.setItems(searchProduct());
            table.getColumns().clear();
            table.getColumns().addAll(columns);
            table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

            // Update tab contents to see changes
            updateTab();
        });

        // Update tab contents to see changes
        updateTab();

        return tabStatistics;
    }

    // Search funtion
    private ObservableList<Product> searchProduct() {
        String sProductName = txtSearch.getText().toString().trim();
        ArrayList<Product> searchResults = new ArrayList<>();

        // Iterate through the pre-created product list and find those matching the search query
        for (Product product : productList) {
            if (product.getName().toLowerCase().contains(sProductName.toLowerCase())) {
                searchResults.add(product);
            }
        }

        return FXCollections.observableArrayList(searchResults);
    }

    // Clear all elements in the tab and re-add them to display changes
    private void updateTab() {
        tabStatistics.getChildren().clear();
        tabStatistics.setMinSize(WIDTH - TAB_WIDTH, HEIGHT - TITLE_BAR_HEIGHT);
        tabStatistics.setSpacing(SPACING);
        tabStatistics.setPadding(new Insets(SPACING, SPACING, SPACING, SPACING));
        tabStatistics.getChildren().addAll(tabTitle, table, hbSearch, productImgView);
    }

    //---------------------TABLE METHODS---------------------
    private ObservableList<Product> getProduct() {
        productList = readCSV.readCSV_product(PRODUCT_DATA_DIR);
        ObservableList<Product> products = FXCollections.observableArrayList(productList);

        return products;
    }

    private TableColumn<Product, String> addStringColumn(String colName, int minWidth, String propertyValue) {
        TableColumn<Product, String> column = new TableColumn<>(colName);
        column.setMinWidth(minWidth);
        column.setCellValueFactory(new PropertyValueFactory<>(propertyValue));
        return column;
    }
}
