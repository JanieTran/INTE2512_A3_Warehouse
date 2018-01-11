package GUI;

import csv.readCSV;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import supportClass.Notifications;

import java.util.ArrayList;

import static GUI.Main.*;

public class TabHome {
    //------------------------------------------------------
    // PROPERTIES
    //------------------------------------------------------
    private final String NOTIFICATIONS_FILE = "src/database/notifications.csv";

    private VBox tabHome;
    private Label tabTitle;
    private VBox boxNoti;

    private ArrayList<Notifications> notifications;

    private Label noNoti = new Label(NO_NOTIFICATION);

    //------------------------------------------------------
    // METHODS
    //------------------------------------------------------

    public TabHome() {
        tabHome = new VBox();
        tabTitle = new Label("NOTIFICATIONS");
        boxNoti = new VBox();
        notifications = readCSV.readCSVtoNotifications(NOTIFICATIONS_FILE);
    }

    public VBox getTabHome() {
        boxNoti.getChildren().clear();

        for (Notifications noti : notifications) {
            GridPane gridNoti = noti.getGrid();
            boxNoti.getChildren().add(gridNoti);
            setGridOnClick(gridNoti);
        }

        boxNoti.setSpacing(SPACING);

        noNoti.setFont(Font.font(20));
        noNoti.setPadding(new Insets(SPACING, SPACING, SPACING, SPACING * 2));
        noNoti.setStyle("-fx-text-fill: #ababab");

        updateTabHome();

        tabTitle.setFont(Font.font(30));
        tabTitle.setStyle("-fx-font-weight: bold; -fx-text-fill: #2196f3");

        tabHome.setMinSize(WIDTH - TAB_WIDTH, HEIGHT - TITLE_BAR_HEIGHT);
        tabHome.setSpacing(SPACING);
        tabHome.setPadding(new Insets(SPACING, SPACING, SPACING, SPACING * 2));

        return tabHome;
    }

    private void setGridOnClick(GridPane grid) {
        grid.setOnMouseClicked(event -> {
            boxNoti.getChildren().remove(grid);
            updateTabHome();
        });
    }

    private void updateTabHome() {
        tabHome.getChildren().clear();

        if (boxNoti.getChildren().isEmpty())
            tabHome.getChildren().addAll(tabTitle, noNoti);
        else
            tabHome.getChildren().addAll(tabTitle, boxNoti);
    }
}
