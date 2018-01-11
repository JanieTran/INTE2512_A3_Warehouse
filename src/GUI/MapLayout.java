package GUI;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import product.Product;
import javafx.scene.control.Label;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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

    private ArrayList<Text> txtTitle = new ArrayList<>();
    private String[] sTitle = {"Product ID:", "Product Name:", "Quantity:", "Description:", "Producer:", "Location:", "Status:", "InputDate:", "OutputDate:"};
    private VBox vbTitle = new VBox();

    private ArrayList<Text> txtBlockInfo = new ArrayList<>();
    private String[] sBlockInfo = {"Product ID:", "Product Name:", "Quantity:", "Description:", "Producer:", "Location:", "Status:", "InputDate:", "OutputDate:"};

    private VBox vbBlockInf = new VBox();
    private GridPane gridMap = new GridPane();
    private Image imgProduct = new Image("image/samsunggalaxys8.jpg");
    private ImageView imgVProduct = new ImageView();


    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create all layout
        createAllLayout();

        // Stage
        window = primaryStage;
        window.setTitle(WINDOW_TITLE);
        Scene sceneMap = new Scene(gridMap, WINDOW_WIDTH, WINDOW_HEIGHT);
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

    // Create grid layout
    private void createGridLayout(GridPane gridPane) {
        gridPane.setHgap(SPACING);
        gridPane.setPadding(new Insets(PADDING, PADDING, PADDING, PADDING));
    }

    // Show block info as user presses on particular rectangle
    private void showRectInfo(ArrayList<Rectangle> rectMap, ArrayList<Text> txtBlockInfo) {
        for (int i = 0; i < 30; i++) {
            int finalI = i;
            rectMap.get(i).setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    System.out.println(products.get(finalI));
                    // Clear All Layout
                    clearAllLayout();
                    // Add Data to String Array
                    addDataToArray(finalI);
                    // Add Data to Text Array
                    addDataToText(txtBlockInfo);
                    // Update All Layout
                    setProductImage(finalI);
                    createAllLayout();
                }
            });
        }
    }

    // read product data from csv file
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

    // Create product
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
        String image = attributes[9];

        return new Product(id, name, qty, desc, producer, location, status, inputDate, outputDate,image);
    }

    // Show block status
    private static void showBlockStatus(ArrayList<Rectangle> rectMap) {
        for (int i = 0; i < 30; i++) {
            int quantity = Integer.parseInt(products.get(i).getQty());
            if (quantity > 0 && quantity < 10) {
                rectMap.get(i).setFill(Color.GREENYELLOW);
            } else if (quantity >= 10 && quantity <= 20) {
                rectMap.get(i).setFill(Color.GREEN);
            } else if (quantity > 20) {
                rectMap.get(i).setFill(Color.RED);
            }
        }
    }

    // Init block title
    private void initTitle(ArrayList<Text> txtTitle, String[] sTitle) {
        for (int i = 0; i < 9; i++) {
            txtTitle.add(new Text(sTitle[i]));
            txtTitle.get(i).setFont(Font.font(15));
            txtTitle.get(i).setStyle("-fx-font-weight: bold");
            vbTitle.getChildren().add(txtTitle.get(i));
        }
    }

    // Add Data to array
    private void addDataToArray(int i) {
        sBlockInfo[0] = products.get(i).getId();
        sBlockInfo[1] = products.get(i).getName();
        sBlockInfo[2] = products.get(i).getQty();
        sBlockInfo[3] = products.get(i).getDesc();
        sBlockInfo[4] = products.get(i).getProducer();
        sBlockInfo[5] = products.get(i).getLocation();
        sBlockInfo[6] = products.get(i).getStatus();
        sBlockInfo[7] = products.get(i).getInputDate();
        sBlockInfo[8] = products.get(i).getOutputDate();
    }

    // Add Data to text array
    private void addDataToText(ArrayList<Text> txtBlockInfo) {
        vbBlockInf.getChildren().clear();
        for (int j = 0; j < 9; j++) {
            txtBlockInfo.add(new Text(sBlockInfo[j]));
            txtBlockInfo.get(j).setFont(Font.font(15));
            vbBlockInf.getChildren().add(txtBlockInfo.get(j));
        }
    }

    // Create VBox for block information
    private void createVBox(VBox vb) {
        vb.setSpacing(3);
    }

    // Add rectangles to grid pane
    private void addRectToGrid() {
        ArrayList<String> sBlockNumber = new ArrayList<>();
        ArrayList<Text> txtBlockNumber = new ArrayList<>();
        for (int i = 1; i < 31; i++) {
            sBlockNumber.add("" + i);
        }
        int col = 0;
        int row = 1;
        for (int i = 0; i < 30; i++) {
            rectMap.add(new Rectangle());
            initRect(rectMap.get(i));

            txtBlockNumber.add(new Text(sBlockNumber.get(i)));
            if (i == 5) {
                row = 1;
                col = 1;
            } else if (i == 10) {
                row = 1;
                col = 2;
            } else if (i == 15) {
                row = 7;
                col = 0;
            } else if (i == 20) {
                row = 7;
                col = 1;
            } else if (i == 25) {
                row = 7;
                col = 2;
            }

            gridMap.add(rectMap.get(i), col, row);
            gridMap.add(txtBlockNumber.get(i), col, row);
            gridMap.setHalignment(txtBlockNumber.get(i), HPos.CENTER);

            row++;


        }
    }

    // Create block name
    private void createBlockName() {
        int col = 0;
        int row = 0;
        String[] blockName = {"A", "B", "C", "D", "E", "F"};
        ArrayList<Label> lblBlockName = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            lblBlockName.add(new Label(blockName[i]));
            lblBlockName.get(i).setFont(Font.font(20));
            lblBlockName.get(i).setPadding(new Insets(PADDING));
            gridMap.add(lblBlockName.get(i), col, row, 1, 1);
            gridMap.setHalignment(lblBlockName.get(i), HPos.CENTER);

            col++;
            if (i == 2) {
                col = 0;
                row = 6;
            }
        }
    }

    // Create all layout
    private void createAllLayout() {
        // Create Grid Layout
        createGridLayout(gridMap);

        // Add rect to grid
        addRectToGrid();

        createBlockName();

        // Show information of rect
        showRectInfo(rectMap, txtBlockInfo);

        // Create VBox Title
        createVBox(vbTitle);

        // Add Title to VBox
        initTitle(txtTitle, sTitle);

        // Create VBox Block Info
        createVBox(vbBlockInf);

        showBlockStatus(rectMap);

        LoginLayout.createImageView(imgVProduct,imgProduct,80,80);

        gridMap.add(vbTitle, 4, 1, 1, 5);
        gridMap.add(vbBlockInf, 5, 1, 1, 5);
    }

    // Clear all layout
    private void clearAllLayout() {
        gridMap.getChildren().clear();
        vbMap.clear();
        vbTitle.getChildren().clear();
        vbBlockInf.getChildren().clear();
        txtBlockInfo.clear();
    }

    private void setProductImage(int i){
        imgProduct = new Image(products.get(i).getImage());
        gridMap.add(imgVProduct,4,0,1,1);
    }


}
