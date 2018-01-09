package GUI;

import csv.writeCSV;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import product.Product;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StatisticsLayout extends Application {
    Stage window;
    TableView<Product> table;

    public static void main(String[] args) {
        launch(args);
    }

    TextField nameIn, idIn, qtyIn, descIn, producerIn, locationIn, statusIn, inputDateIn, outputDateIn;


    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Statistics");
        Button addButton, deleteButton;

        //name column
        TableColumn<Product, String> nameCol = addStringColumn("Name", 100, "name");

        //id column
        TableColumn<Product, String> idCol = addStringColumn("ID", 100, "id");

        //qty column
        TableColumn<Product, Integer> qtyCol = new TableColumn<>("Quantity");
        qtyCol.setMinWidth(200);
        qtyCol.setCellValueFactory(new PropertyValueFactory<>("qty"));

        //desc column
        TableColumn<Product, String> descCol = addStringColumn("Description", 100, "desc");

        //producer column
        TableColumn<Product, String> producerCol = addStringColumn("Producer", 100, "producer");

        //location column
        TableColumn<Product, String> locationCol = addStringColumn("Location", 100, "location");

        //status column
        TableColumn<Product, String> statusCol = addStringColumn("Status", 100, "status");

        //inputDate column
        TableColumn<Product, String> inputDateCol = addStringColumn("Input Date", 100, "inputDate");

        //outputDare
        TableColumn<Product, String> outputDateCol = addStringColumn("Output Date", 100, "outputDate");

        //---------------------add new item--------------------
        //textfield
        //name input
        nameIn = new TextField();
        nameIn.setPromptText("Name");
        nameIn.setPrefWidth(100);
        //ID input
        idIn = new TextField();
        idIn.setPromptText("ID");
        idIn.setPrefWidth(100);
        //quantity input
        qtyIn = new TextField();
        qtyIn.setPromptText("Quantity");
        qtyIn.setPrefWidth(100);
        //description input
        descIn = new TextField();
        descIn.setPromptText("Description");
        descIn.setPrefWidth(100);
        //producer input
        producerIn = new TextField();
        producerIn.setPromptText("Producer");
        producerIn.setPrefWidth(100);
        //location input
        locationIn = new TextField();
        locationIn.setPromptText("Location");
        locationIn.setPrefWidth(100);
        //status input
        statusIn = new TextField();
        statusIn.setPromptText("Status");
        //location input
        inputDateIn = new TextField();
        inputDateIn.setPromptText("Input date");
        //location input
        outputDateIn = new TextField();
        outputDateIn.setPromptText("Output Date");






        //button
        addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());
        deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(20,20,20,20));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameIn, idIn, qtyIn, descIn, producerIn, locationIn,
                statusIn, inputDateIn, outputDateIn,addButton, deleteButton);

        //set up table view
        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(nameCol, idCol, qtyCol, descCol, producerCol, locationCol, statusCol, inputDateCol, outputDateCol);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    //get all the products
    public ObservableList<Product> getProduct() {
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("KABY LAKE", "ABC2345", 1000));
        products.add(new Product("SAMSUNG NOTE 8", "SSN2345", 2000));
        products.add(new Product("IPHONE X", "IPX2345", 500));
        products.add(new Product());

        return products;
    }

    //create column for TableView
    public TableColumn<Product, String> addStringColumn(String colName, int minWidth, String propertyValue) {
        TableColumn<Product, String> column = new TableColumn<>(colName);
        column.setMinWidth(minWidth);
        column.setCellValueFactory(new PropertyValueFactory<>(propertyValue));

        return column;
    }

    //add new item addButtonClicked()
    private void addButtonClicked() {
        Product product = new Product();
        product.setName(nameIn.getText());
        product.setId(idIn.getText());
        product.setQty(Integer.parseInt(qtyIn.getText()));
        product.setDesc(descIn.getText());
        product.setProducer(producerIn.getText());
        product.setLocation(locationIn.getText());
        product.setStatus(statusIn.getText());

        table.getItems().add(product);
        writeCSV.writeData("data.csv", product);

        nameIn.clear();
        idIn.clear();
        qtyIn.clear();
        descIn.clear();
        producerIn.clear();
        locationIn.clear();
        statusIn.clear();
    }

    private void deleteButtonClicked() {
        ObservableList<Product> productsSelected, allProducts;
        allProducts = table.getItems();
        productsSelected = table.getSelectionModel().getSelectedItems();

        productsSelected.forEach(allProducts::remove);
    }
}
