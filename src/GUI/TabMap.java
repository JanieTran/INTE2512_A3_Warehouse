/*
  RMIT University Vietnam
  Course: INTE2512 Object-Oriented Programming
  Semester: 2017C
  Assignment: 3 - Warehouse Management Application

  Authors:
    - Nguyen Tan Thanh          s3580014
    - Tran le Nha Tran          s3533562
    - Tran Thi Hong Phuong      s3623385

  Created date: 04/01/2018

  Description: This app gives the overview and statistics of a warehouse so that
  the manager can monitor and control the delivery of packages inside that warehouse.

  Acknowledgement:
  - https://www.youtube.com/watch?v=FLkOX4Eez6o&list=PL6gx4Cwl9DGBzfXLWLSYVy8EbTdpGbUIG
  - https://stackoverflow.com/

*/

package GUI;

import csv.readCSV;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import supportClass.Product;

import java.util.ArrayList;

public class TabMap {
    private static final String DATA_CSV_FILE_PATH = "src/database/product.csv";

    private static ArrayList<Product> products = readCSV.readCSV_product(DATA_CSV_FILE_PATH);

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
    private VBox tabMap;
    private Label tabTitle;

    public TabMap() {
        // Init nodes
        tabMap = new VBox();
        tabTitle = new Label("WAREHOUSE MAP");
    }

    public VBox getTabMap() {
        // Clear all layout
        tabMap.getChildren().clear();
        clearAllLayout();

        // Create all layout
        createAllLayout();

        // Tab title
        tabTitle.setFont(Font.font(30));
        tabTitle.setStyle("-fx-font-weight: bold; -fx-text-fill: #2196f3");

        // Tab Map
        tabMap.getChildren().addAll(tabTitle, gridMap);
        tabMap.setPadding(new Insets(SPACING, SPACING, SPACING, SPACING * 2));

        return tabMap;
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
        gridPane.setPadding(new Insets(0, PADDING, PADDING, PADDING * 2));
    }

    // Show block info as user presses on particular rectangle
    private void showRectInfo(ArrayList<Rectangle> rectMap, ArrayList<Text> txtBlockInfo) {
        for (int i = 0; i < 30; i++) {
            int finalI = i;
            rectMap.get(i).setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
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

    // Show block status according to product's quantity
    private static void showBlockStatus(ArrayList<Rectangle> rectMap) {
        for (int i = 0; i < 30; i++) {
            int quantity = products.get(i).getQty();
            if (quantity > 0 && quantity < 10) {
                rectMap.get(i).setFill(Color.GREENYELLOW);
            } else if (quantity >= 10 && quantity <= 20) {
                rectMap.get(i).setFill(Color.GREEN);
            } else if (quantity > 20) {
                rectMap.get(i).setFill(Color.RED);
            }else if (i ==0) {
                rectMap.get(i).setFill(Color.WHITE);
            }
        }
    }

    // Init block info title
    private void initTitle(ArrayList<Text> txtTitle, String[] sTitle) {
        for (int i = 0; i < 9; i++) {
            txtTitle.add(new Text(sTitle[i]));
            txtTitle.get(i).setFont(Font.font(15));
            txtTitle.get(i).setStyle("-fx-font-weight: bold");
            vbTitle.getChildren().add(txtTitle.get(i));
        }
    }

    // Add Data to block info string array
    private void addDataToArray(int i) {
        sBlockInfo[0] = products.get(i).getId();
        sBlockInfo[1] = products.get(i).getName();
        sBlockInfo[2] = String.valueOf(products.get(i).getQty());
        sBlockInfo[3] = products.get(i).getDesc();
        sBlockInfo[4] = products.get(i).getProducer();
        sBlockInfo[5] = products.get(i).getLocation();
        sBlockInfo[6] = products.get(i).getStatus();
        sBlockInfo[7] = products.get(i).getInputDate();
        sBlockInfo[8] = products.get(i).getOutputDate();
    }

    // Add Data to block info text array
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
        // Init block number
        for (int i = 1; i < 31; i++) {
            sBlockNumber.add("" + i);
        }
        int col = 0;
        int row = 1;
        for (int i = 0; i < 30; i++) {
            // Init rectangle arraylist
            rectMap.add(new Rectangle());
            initRect(rectMap.get(i));
            // Add 5 rectangles and their number to each column
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
        // Add name to each rectangle
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

        // Show blocks status according to their product quantity
        showBlockStatus(rectMap);

        // Create product image view
        LoginLayout.createImageView(imgVProduct,imgProduct,80,80);

        // Add block info title and block data to grid pane
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

    // Set image to Grid Pane
    private void setProductImage(int i){
        imgProduct = new Image(products.get(i).getImage());
        gridMap.add(imgVProduct,4,0,1,1);
    }

}
