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
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.Random;
import static GUI.Main.*;
import static GUI.Main.SPACING;
import static GUI.TabStatistics.PRODUCT_DATA_DIR;

public class TabReceiver {
    //--------------------CONSTANTS--------------------
    private static final String TAB_NAME = "RECEIVER";

    //--------------------TAB PROPERTIES--------------------
    private VBox tabReceiver;
    private Label tabTitle;
    private ScrollPane scrollPane;
    private GridPane bar;
    private ArrayList<Label> idLabel;
    private ArrayList<Label> qtyLabel;
    private Rectangle[] rFull;
    private Rectangle[] rPercentage;
    Random random;

    public TabReceiver() {
        tabReceiver = new VBox();
        scrollPane = new ScrollPane();
        bar = new GridPane();
        tabTitle = new Label(TAB_NAME);
        random = new Random();
        idLabel = new ArrayList<>();
        qtyLabel = new ArrayList<>();
    }

    public VBox getTabReceiver() {
        tabReceiver.getChildren().clear();

        //---------------------CUSTOM tabTitle---------------------
        tabTitle.setFont(Font.font(30));
        tabTitle.setStyle("-fx-font-weight: bold; -fx-text-fill: #2196f3");

        //---------------------CUSTOM bar---------------------
        bar.setPadding(new Insets(30, 30, 30, 30));
        bar.setHgap(10);
        bar.setVgap(10);

        //total number of input
        int size = 0;
        size = readCSV.readCSV_receiver(PRODUCT_DATA_DIR).size();

        //rectangle
        rFull = new Rectangle[size];
        rPercentage = new Rectangle[size];

        for(int row = 0; row < size; row++) {
            idLabel.add(new Label(readCSV.readCSV_receiver(PRODUCT_DATA_DIR).get(row).getId()));
            idLabel.set(row, new Label(readCSV.readCSV_receiver(PRODUCT_DATA_DIR).get(row).getId()));
            idLabel.get(row).setPrefWidth(100);
            idLabel.get(row).setFont(Font.font(20));
            GridPane.setConstraints(idLabel.get(row), 0, row);

            qtyLabel.add(new Label("/" + String.valueOf(readCSV.readCSV_receiver(PRODUCT_DATA_DIR).get(row).getQty())));
            qtyLabel.set(row, new Label("/" + String.valueOf(readCSV.readCSV_receiver(PRODUCT_DATA_DIR).get(row).getQty())));
            qtyLabel.get(row).setFont(Font.font(20));
            GridPane.setConstraints(qtyLabel.get(row), 2, row);

            rFull[row] = new Rectangle(50, 50, 600, 40);
            GridPane.setConstraints(rFull[row], 1, row);
            rFull[row].setFill(Color.web("#BDBDBD"));

            rPercentage[row] = new Rectangle(50, 50, random.nextInt(600 + 1), 40);
            rPercentage[row].setFill(Color.web("#4CAF50"));
            GridPane.setConstraints(rPercentage[row], 1, row);

            bar.getChildren().addAll(idLabel.get(row), rFull[row], rPercentage[row], qtyLabel.get(row));
        }

        //---------------------CUSTOM tabReceiver---------------------
        scrollPane.setPrefViewportHeight(500);
        scrollPane.setContent(bar);
        tabReceiver.setMinSize(WIDTH - TAB_WIDTH, HEIGHT - TITLE_BAR_HEIGHT);
        tabReceiver.setSpacing(SPACING);
        tabReceiver.setPadding(new Insets(SPACING, SPACING, SPACING, SPACING));

        tabReceiver.getChildren().addAll(tabTitle, scrollPane);
        return tabReceiver;
    }
}

