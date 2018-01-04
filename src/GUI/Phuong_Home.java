package GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Phuong_Home extends Application{
    // Int constants
    private final int WIDTH = 1280;
    private final int HEIGHT = 720;
    private final int TITLE_BAR_HEIGHT = 50;
    private final int TABS_WIDTH = 250;
    private final int TAB_HEIGHT = 70;
    private final int SPACING = 20;

    // String constants
    private final String APP_TITLE = "Warehouse Management";

    // Screen box
    VBox screen = new VBox();

    // Objects for title bar: title label, username label, log out button
    HBox titleBar = new HBox();
    Label title = new Label(APP_TITLE);
    Label username = new Label("Username");
    Button logOut = new Button("Log Out");

    // Tab buttons
    VBox tabs = new VBox();
    Button home = new Button("Home");
    Button order = new Button("Order");

    // Contents
    Label noti = new Label("Notifications");
    Label notiTitle = new Label("ABC1232 Input Completed");
    Label notiSub = new Label("7:22 PM 31/12/2017");
    Button view = new Button("View");
    Button dismiss = new Button("Dismiss");

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Set Title Bar
        setTitleBar();

        // TABS

        // Set properties for Tabs box
        tabs.getChildren().addAll(home, order);
        tabs.setMaxWidth(TABS_WIDTH);
        tabs.setMinHeight(HEIGHT - TITLE_BAR_HEIGHT);
        tabs.setStyle("-fx-background-color: #bababa");

        // Set properties for Home button
        home.setMinSize(TABS_WIDTH, TAB_HEIGHT);
        home.setStyle("-fx-background-color: transparent");
        home.setFont(Font.font(20));

        // Set properties for Order button
        order.setMinSize(TABS_WIDTH, TAB_HEIGHT);
        order.setStyle("-fx-background-color: transparent");
        order.setFont(Font.font(20));

        // Add all to Screen box
        screen.getChildren().addAll(titleBar, tabs);

        Scene scene = new Scene(screen);
        setStage(primaryStage, scene);
    }

    private void setStage(Stage primaryStage, Scene scene) {
        primaryStage.setTitle(APP_TITLE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setTitleBar() {
        // Set properties for Title Bar
        titleBar.setPadding(new Insets(0,0,0,10));
        titleBar.getChildren().addAll(title, username, logOut);
        titleBar.setMinSize(WIDTH, TITLE_BAR_HEIGHT);
        titleBar.setStyle("-fx-background-color: #5495ff");

        // Set properties for Title
        title.setMinSize(1000, TITLE_BAR_HEIGHT);
        title.setFont(Font.font(30));

        // Set properties for Username
        username.setMinSize(140, TITLE_BAR_HEIGHT);
        username.setFont(Font.font(20));

        // Set properties for Log Out button
        logOut.setMinSize(140, TITLE_BAR_HEIGHT);
        logOut.setFont(Font.font(20));
        logOut.setStyle("-fx-background-color: transparent");
    }
}
