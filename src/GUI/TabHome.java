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

    // Display elements
    private VBox tabHome;
    private Label tabTitle;
    private VBox boxNoti;
    private Label noNoti;

    // List of Notification objects to be displayed
    private ArrayList<Notifications> notifications;

    //------------------------------------------------------
    // METHODS
    //------------------------------------------------------

    // Initialise all properties
    public TabHome() {
        tabHome = new VBox();
        tabTitle = new Label("NOTIFICATIONS");
        boxNoti = new VBox();
        noNoti = new Label(NO_NOTIFICATION);

        notifications = readCSV.readCSV_notifications(NOTIFICATIONS_FILE);
    }

    // Prepare contents for Main scene
    public VBox getTabHome() {
        // Each time the method is called, the contents are refreshed to avoid duplicating children
        boxNoti.getChildren().clear();

        // Get grid pane of each object in the Notifications list
        for (Notifications noti : notifications) {
            GridPane gridNoti = noti.getGrid();

            // Add the grid pane to the VBox displaying notifications
            boxNoti.getChildren().add(gridNoti);

            // Click event listener for each notification
            setGridOnClick(gridNoti);
        }

        // Spacing between notifications
        boxNoti.setSpacing(SPACING);

        // Settings for message when there is no notifications
        noNoti.setFont(Font.font(20));
        noNoti.setPadding(new Insets(SPACING, SPACING, SPACING, SPACING * 2));
        noNoti.setStyle("-fx-text-fill: #ababab");

        updateTabHome();

        // Settings for title of the tab
        tabTitle.setFont(Font.font(30));
        tabTitle.setStyle("-fx-font-weight: bold; -fx-text-fill: #2196f3");

        // Settings for the tab contents display
        tabHome.setMinSize(WIDTH - TAB_WIDTH, HEIGHT - TITLE_BAR_HEIGHT);
        tabHome.setSpacing(SPACING);
        tabHome.setPadding(new Insets(SPACING, SPACING, SPACING, SPACING * 2));

        return tabHome;
    }

    // When a notification is clicked, it removes itself from the list
    // indicating that the user has resolved the notification
    private void setGridOnClick(GridPane grid) {
        grid.setOnMouseClicked(event -> {
            boxNoti.getChildren().remove(grid);
            updateTabHome();
        });
    }

    // If notification list is empty, show message saying no notifications,
    // else show the list
    private void updateTabHome() {
        tabHome.getChildren().clear();

        if (boxNoti.getChildren().isEmpty())
            tabHome.getChildren().addAll(tabTitle, noNoti);
        else
            tabHome.getChildren().addAll(tabTitle, boxNoti);
    }
}
