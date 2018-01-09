package GUI;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import product.Product;

import java.awt.*;
import java.util.ArrayList;


public class LoginLayout extends Application {
    private Stage window;

    static TableView<Product> table = new TableView<Product>();
   static ArrayList<Product> productList = new ArrayList<>();

    private static final ObservableList<Product> data =
            FXCollections.observableArrayList(
                    new Product("Jacob", "Smith", 100),
                    new Product("Isabella", "Johnson", 200),
                    new Product("Ethan", "Williams", 300),
                    new Product("Emma", "Jones",400),
                    new Product("Michael", "Brown", 500));

    //Constant variables
    private final int WINDOW_WIDTH = 400;
    private final int WINDOW_HEIGHT = 400;
    private final int SPACING = 15;
    private final int PADDING = 25;
    private final String USER_NAME_HINT = "Enter your name";
    private final String USER_PASSWORD_HINT = "Password";
    private final String WINDOW_TITLE = "LOGIN";

    private final int STROKE_WIDTH = 1;
    private final int RECT_WIDTH = 150;
    private final int RECT_HEIGHT = 40;

    private ArrayList<Rectangle> rectMap = new ArrayList<>();
    private ArrayList<VBox> vbMap = new ArrayList<>();
    private static ArrayList<String> boxName = new ArrayList<>();



    @Override
    public void start(Stage primaryStage) throws Exception {

        for (int i = 0; i < 31; i++) {
            boxName.add("" + i);
            System.out.println(boxName.toString());

        }

        blockData();
        // Login Layout
        // Images
        Image imgUser = new Image("image/ic_user.png");
        Image imgPassword = new Image("image/ic_password.png");
        Image imgLogin = new Image("image/ic_login.png");

        ImageView imgVUser = new ImageView();
        createImageView(imgVUser, imgUser, 25, 25);

        ImageView imgVPassword = new ImageView();
        createImageView(imgVPassword, imgPassword, 25, 25);

        ImageView imgVLogin = new ImageView();
        createImageView(imgVLogin, imgLogin, 100, 100);


        // Grid layout
        GridPane gridLogin = new GridPane();
        createGridLayout(gridLogin);

        // Rectangle
        Rectangle rect = new Rectangle(200, 200);
        rect.setFill(Color.LIGHTGREY);
        gridLogin.add(rect, 0, 0, 3, 14);


        // Login Icon
        HBox hbImgLogin = new HBox(SPACING);
        hbImgLogin.setAlignment(Pos.BOTTOM_CENTER);
        hbImgLogin.getChildren().add(imgVLogin);
        gridLogin.add(hbImgLogin, 0, 1, 3, 1);

        // User name
        gridLogin.add(imgVUser, 0, 4);
        TextField txtUserName = new TextField();
        txtUserName.setPromptText(USER_NAME_HINT);
        gridLogin.add(txtUserName, 1, 4);

        // User password
        gridLogin.add(imgVPassword, 0, 5);
        TextField txtPassword = new TextField();
        txtPassword.setPromptText(USER_PASSWORD_HINT);
        gridLogin.add(txtPassword, 1, 5);


        // Login button
        Button btnLogin = new Button("Sign in");
        HBox hbLogin = new HBox(SPACING);
        hbLogin.setAlignment(Pos.BOTTOM_CENTER);
        hbLogin.getChildren().add(btnLogin);
        gridLogin.add(hbLogin, 0, 7, 3, 1);

        createVBMap(vbMap);
        createRectMap(rectMap);

        // Show information of rect
        showRectInfo();

        // Stage
        window = primaryStage;
        window.setTitle(WINDOW_TITLE);
        Scene sceneLogin = new Scene(gridLogin, WINDOW_WIDTH, WINDOW_HEIGHT);
        Scene sceneMap = new Scene(createGridMap(), 1280, 720);
        window.setScene(sceneMap);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    // Init rectangles' properties
    private void initRect(Rectangle rectMap) {
        rectMap.setHeight(RECT_HEIGHT);
        rectMap.setWidth(RECT_WIDTH);
        rectMap.setFill(Color.GREEN);
        rectMap.setStroke(Color.GRAY);
        rectMap.setStrokeWidth(STROKE_WIDTH);
    }

    // Create rectangles
    private void createRectMap(ArrayList<Rectangle> rectMap) {
        for (int j = 0; j < 30; j++) {
            int i = 0;
            rectMap.add(new Rectangle());
            initRect(rectMap.get(j));
            if (j < 5) {
                vbMap.get(0).getChildren().add(rectMap.get(j));

            } else if (j > 5 && j < 11) {
                vbMap.get(1).getChildren().add(rectMap.get(j));

            } else if (j > 10 && j < 16) {
                vbMap.get(2).getChildren().add(rectMap.get(j));

            } else if (j > 15 && j < 21) {
                vbMap.get(3).getChildren().add(rectMap.get(j));

            } else if (j > 20 && j < 26) {
                vbMap.get(4).getChildren().add(rectMap.get(j));

            } else {
                vbMap.get(5).getChildren().add(rectMap.get(j));
            }


        }
    }

    // Create VBoxes containing rectangles
    private void createVBMap(ArrayList<VBox> vbMap) {
        for (int i = 0; i < 7; i++) {
            vbMap.add(new VBox());
            vbMap.get(i).setPadding(new Insets(PADDING, PADDING, PADDING, PADDING));
        }
    }

    // Create Grid pane containing VBoxes on map
    private GridPane createGridMap() {
        GridPane gridMap = new GridPane();
        createGridLayout(gridMap);
        int col = 0;
        int row = 0;
        for (int i = 0; i < 6; i++) {
            gridMap.add(vbMap.get(i), col, row);
            col++;
            if (i == 2) {
                col = 0;
                row = 1;
            }

        }
        return gridMap;
    }

    // Create Image View
    private void createImageView(ImageView imgView, Image img, int width, int height) {
        imgView.setImage(img);
        imgView.setFitWidth(width);
        imgView.setFitHeight(height);
        imgView.setPreserveRatio(true);
        imgView.setSmooth(true);
        imgView.setCache(true);
    }

    // Create grid layout
    private void createGridLayout(GridPane gridPane) {
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(SPACING);
        gridPane.setVgap(SPACING);
        gridPane.setPadding(new Insets(PADDING, PADDING, PADDING, PADDING));
    }

    private void showRectInfo() {
        for (int i = 0; i < 30; i++) {
            int finalI = i;
            rectMap.get(i).setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    System.out.println(boxName.get(finalI));
//                    BlockInfo blkInfo = new BlockInfo(boxName.get(finalI),boxName.get(finalI));
//                    blockInfo.add(blkInfo);

                    table.getItems().add(productList.get(finalI));
                    display(boxName.get(finalI));
                    data.clear();
                }
            });
        }
    }

    //create column for TableView
    public static TableColumn<Product, String> addStringColumn(String colName, int minWidth, String propertyValue) {
        TableColumn<Product, String> column = new TableColumn<>(colName);
        column.setMinWidth(minWidth);
        column.setCellValueFactory(new PropertyValueFactory<>(propertyValue));

        return column;
    }

    public static void display(String title) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);


        Button closeButton = new Button("Finish");
        closeButton.setOnAction(e -> window.close());

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

//        table = new TableView<>();
        table.setItems(data);
        table.getColumns().addAll(nameCol, idCol, qtyCol, descCol, producerCol, locationCol, statusCol, inputDateCol, outputDateCol);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.showAndWait();
    }

    //get all the products
    public static void getProduct() {
//        ObservableList<Product> products = FXCollections.observableArrayList();
        data.add(new Product("KABY LAK", "ABC2345", 1000));
        data.add(new Product("SAMSUNG NOTE 8", "SSN2345", 2000));
        data.add(new Product("IPHONE X", "IPX2345", 500));

//        return products;
    }

    private static void blockData(){
        for (int i = 0; i< 30;i++){
                productList.add(i,new Product(boxName.get(i),boxName.get(i),100));
        }
    }


}
