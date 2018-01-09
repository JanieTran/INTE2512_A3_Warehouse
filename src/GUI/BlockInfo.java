package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import product.Product;


public class BlockInfo {

//    static TableView<Product> table;
//
//
//    public static void display(String title) {
//        Stage window = new Stage();
//        window.initModality(Modality.APPLICATION_MODAL);
//        window.setTitle(title);
//        window.setMinWidth(250);
//
//
//        Button closeButton = new Button("Finish");
//        closeButton.setOnAction(e -> window.close());
//
//        //name column
//        TableColumn<Product, String> nameCol = addStringColumn("Name", 100, "name");
//
//        //id column
//        TableColumn<Product, String> idCol = addStringColumn("ID", 100, "id");
//
//        //qty column
//        TableColumn<Product, Integer> qtyCol = new TableColumn<>("Quantity");
//        qtyCol.setMinWidth(200);
//        qtyCol.setCellValueFactory(new PropertyValueFactory<>("qty"));
//
//        //desc column
//        TableColumn<Product, String> descCol = addStringColumn("Description", 100, "desc");
//
//        //producer column
//        TableColumn<Product, String> producerCol = addStringColumn("Producer", 100, "producer");
//
//        //location column
//        TableColumn<Product, String> locationCol = addStringColumn("Location", 100, "location");
//
//        //status column
//        TableColumn<Product, String> statusCol = addStringColumn("Status", 100, "status");
//
//        //inputDate column
//        TableColumn<Product, String> inputDateCol = addStringColumn("Input Date", 100, "inputDate");
//
//        //outputDare
//        TableColumn<Product, String> outputDateCol = addStringColumn("Output Date", 100, "outputDate");
//
//        table = new TableView<>();
//        table.setItems(getProduct());
//        table.getColumns().addAll(nameCol, idCol, qtyCol, descCol, producerCol, locationCol, statusCol, inputDateCol, outputDateCol);
//
//        VBox vBox = new VBox();
//        vBox.getChildren().addAll(table);
//
//        Scene scene = new Scene(vBox);
//        window.setScene(scene);
//        window.showAndWait();
//    }
//
//    //get all the products
//    public static ObservableList<Product> getProduct() {
//        ObservableList<Product> products = FXCollections.observableArrayList();
//        products.add(new Product("KABY LAK", "ABC2345", 1000));
//        products.add(new Product("SAMSUNG NOTE 8", "SSN2345", 2000));
//        products.add(new Product("IPHONE X", "IPX2345", 500));
//        products.add(new Product());
//
//        return products;
//    }
//
//    //create column for TableView
//    public static TableColumn<Product, String> addStringColumn(String colName, int minWidth, String propertyValue) {
//        TableColumn<Product, String> column = new TableColumn<>(colName);
//        column.setMinWidth(minWidth);
//        column.setCellValueFactory(new PropertyValueFactory<>(propertyValue));
//
//        return column;
//    }
}
