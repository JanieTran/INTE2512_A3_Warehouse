package GUI;

import supportClass.Product;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StatisticsLayout extends Application {
    Stage window;
    TableView<Product> table;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("v17_Table View");

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

        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(nameCol, idCol, qtyCol, descCol, producerCol, locationCol, statusCol, inputDateCol, outputDateCol);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table);

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
}
