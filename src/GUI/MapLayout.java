package GUI;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import product.Product;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MapLayout extends Application {
    private Stage window;
    private final String WINDOW_TITLE = "MAP";
    private static final String DATA_CSV_FILE_PATH = "product.csv";

    private static List<Product> products = readProductsFromCSV(DATA_CSV_FILE_PATH);
    private final int WINDOW_WIDTH = 1280;
    private final int WINDOW_HEIGHT = 720;
    private final int SPACING = 15;
    private final int PADDING = 25;

    private final int STROKE_WIDTH = 1;
    private final int RECT_WIDTH = 150;
    private final int RECT_HEIGHT = 40;

    private static ArrayList<Rectangle> rectMap = new ArrayList<>();
    private ArrayList<VBox> vbMap = new ArrayList<>();
    private static ArrayList<Label> lblBlock = new ArrayList<>();



    @Override
    public void start(Stage primaryStage) throws Exception {


        createVBMap(vbMap);

        createRectMap(rectMap);

        // Show information of rect
        showRectInfo();

        checkQuantity();

        // Stage
        window = primaryStage;
        window.setTitle(WINDOW_TITLE);
        Scene sceneMap = new Scene(createGridMap(), WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setScene(sceneMap);
        window.show();

    }

    // Init rectangles' properties
    private void initRect(Rectangle rectMap) {
        rectMap.setHeight(RECT_HEIGHT);
        rectMap.setWidth(RECT_WIDTH);
        rectMap.setFill(Color.WHITE);
        rectMap.setStroke(Color.GRAY);
        rectMap.setStrokeWidth(STROKE_WIDTH);
    }

    // Create rectangles
    private void createRectMap(ArrayList<Rectangle> rectMap) {
        for (int j = 0; j < 30; j++) {
            int i = 0;
            rectMap.add(new Rectangle());
            initRect(rectMap.get(j));
            if (j <= 4) {
                vbMap.get(0).getChildren().add(rectMap.get(j));

            } else if (j >= 5 && j < 10) {
                vbMap.get(1).getChildren().add(rectMap.get(j));

            } else if (j >= 10 && j < 15) {
                vbMap.get(2).getChildren().add(rectMap.get(j));

            } else if (j >= 15 && j < 20) {
                vbMap.get(3).getChildren().add(rectMap.get(j));

            } else if (j >= 20 && j < 25) {
                vbMap.get(4).getChildren().add(rectMap.get(j));

            } else {
                vbMap.get(5).getChildren().add(rectMap.get(j));
            }


        }
    }

    // Create VBoxes containing rectangles
    private void createVBMap(ArrayList<VBox> vbMap) {
        for (int i = 0; i < 6; i++) {
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
                    System.out.println(products.get(finalI));
//                    BlockInfo blkInfo = new BlockInfo(boxName.get(finalI),boxName.get(finalI));
//                    blockInfo.add(blkInfo);

                }
            });
        }
    }

    private static List<Product> readProductsFromCSV(String fileName) {
        List<Product> products = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            String line = br.readLine();

            while (line != null) {
                String[] attributes = line.split(",");
                Product product = createProduct(attributes);
                products.add(product);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;

    }

    private static Product createProduct(String[] attributes) {

        String id = attributes[0];
        String name = attributes[1];
        String qty = (attributes[2]);
        String desc = attributes[3];
        String producer = attributes[4];
        String location = attributes[5];
        String status = attributes[6];
        String inputDate = attributes[7];
        String outputDate = attributes[8];

        return new Product(id, name, qty, desc, producer, location, status, inputDate, outputDate);
    }

    private static void checkQuantity() {
        for (int i = 0; i < 30; i++) {
            int quantity = Integer.parseInt(products.get(i).getQty());
           if(quantity>0&&quantity<10){
               rectMap.get(i).setFill(Color.GREENYELLOW);
           }else if (quantity>=10 && quantity<=20){
               rectMap.get(i).setFill(Color.GREEN);
           }else if(quantity >20){
               rectMap.get(i).setFill(Color.RED);
           }
        }
    }

    private static void showBlockInfo(ArrayList<Label> lblBlock){
        HBox hbBlockInfo = new HBox();

        for (int i =0;i<9;i++){
            hbBlockInfo.getChildren().addAll((Collection<? extends Node>) lblBlock.get(i));
        }

    }

    private void initLabel(ArrayList<Label> lblBlock){
        String[] blockLabel = {"Product ID","Product Name","Quantity","Description","Producer","Location","Status","InputDate","OutputDate"};
        for (int i =0;i<9;i++){
            lblBlock.add(new Label());
            lblBlock.get(i).setText(blockLabel[i]);
        }
    }

}
