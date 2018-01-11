
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

import static GUI.Main.*;
import static GUI.TabStatistics.PRODUCT_DATA_DIR;

public class TabDeliver {
    //--------------------CONSTANTS--------------------
    private static final String TAB_NAME = "DELIVER";

    //--------------------TAB PROPERTIES--------------------
    private VBox tabDeliver;
    private Label tabTitle;
    private ScrollPane scrollPane;
    private GridPane bar;
    private Label[] idLabel;
    private int totalProduct;
    private Rectangle[] rFull;
    private Rectangle[] rPercentage;

    public TabDeliver() {
        tabDeliver = new VBox();
        scrollPane = new ScrollPane();
        bar = new GridPane();
        tabTitle = new Label(TAB_NAME);
    }

    public VBox getTabReceiver() {
        tabDeliver.getChildren().clear();

        //---------------------CUSTOM tabTitle---------------------
        tabTitle.setFont(Font.font(30));
        tabTitle.setStyle("-fx-font-weight: bold; -fx-text-fill: #2196f3");

        //---------------------CUSTOM bar---------------------
        bar.setPadding(new Insets(30, 30, 30, 30));
        bar.setHgap(10);
        bar.setVgap(10);

        totalProduct = readCSV.count(PRODUCT_DATA_DIR);
        idLabel = new Label[totalProduct];

        rFull = new Rectangle[totalProduct];
        rPercentage = new Rectangle[totalProduct];

        for(int row = 0; row < totalProduct; row++) {
            idLabel[row] = new Label(readCSV.readCSV_product(PRODUCT_DATA_DIR).get(row).getId());
            idLabel[row].setPrefWidth(100);
            idLabel[row].setFont(Font.font(20));
            GridPane.setConstraints(idLabel[row], 0, row);

            rFull[row] = new Rectangle(50, 50, 600, 40);
            GridPane.setConstraints(rFull[row], 1, row);
            rFull[row].setFill(Color.web("#BDBDBD"));

            rPercentage[row] = new Rectangle(50, 50, 500, 40);
            rPercentage[row].setFill(Color.web("#E64A19"));
            GridPane.setConstraints(rPercentage[row], 1, row);

            bar.getChildren().addAll(idLabel[row], rFull[row], rPercentage[row]);
        }

        //---------------------CUSTOM tabReceiver---------------------
        scrollPane.setPrefViewportHeight(500);
        scrollPane.setContent(bar);
        tabDeliver.setMinSize(WIDTH - TAB_WIDTH, HEIGHT - TITLE_BAR_HEIGHT);
        tabDeliver.setSpacing(SPACING);
        tabDeliver.setPadding(new Insets(SPACING, SPACING, SPACING, SPACING));

        tabDeliver.getChildren().addAll(tabTitle, scrollPane);
        return tabDeliver;
    }
}

