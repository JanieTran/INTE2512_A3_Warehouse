package GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application{
    ////////////////////////////////////////////////////////
    // PROPERTIES
    ////////////////////////////////////////////////////////

    // Int constants
    static final int WIDTH = 1280;
    static final int HEIGHT = 720;
    static final int TITLE_BAR_HEIGHT = 50;
    static final int TAB_WIDTH = 200;
    static final int TAB_HEIGHT = 80;
    static final int SPACING = 20;
    static final int ICON_DIMEN = 35;

    // String constants
    private final String APP_TITLE = "Warehouse Management";

    // Screen box
    VBox screen = new VBox();

    // Objects for title bar: title label, username label, log out button
    HBox titleBar = new HBox();
    Label title = new Label(APP_TITLE);
    Label username = new Label("Username");
    Button logOut = new Button("Log Out");

    // Tab buttons + icons
    VBox tabs = new VBox();

    Image ic_home = fetchImg("ic_home.png");
    Button home = new Button("Home", new ImageView(ic_home));

    Image ic_order = fetchImg("ic_order.png");
    Button order = new Button("Order", new ImageView(ic_order));

    Image ic_receiver = fetchImg("ic_receiver.png");
    Button receiver = new Button("Receiver", new ImageView(ic_receiver));

    Image ic_deliver = fetchImg("ic_deliver.png");
    Button deliver = new Button("Deliver", new ImageView(ic_deliver));

    Image ic_statistics = fetchImg("ic_statistics.png");
    Button statistics = new Button("Statistics", new ImageView(ic_statistics));

    Image ic_map = fetchImg("ic_map.png");
    Button map = new Button("Map", new ImageView(ic_map));

    // Contents
    HBox boxTabsContents = new HBox();
    VBox contents = new VBox();

    ////////////////////////////////////////////////////////
    // MAIN FUNCTION
    ////////////////////////////////////////////////////////

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Set Title Bar
        setTitleBar();

        // Tabs column
        setTabsColumn();

        // Box containing tabs column and tab contents
        contents = TabHome.getTabHome();
        boxTabsContents.setMinSize(WIDTH, HEIGHT - TITLE_BAR_HEIGHT);
        boxTabsContents.getChildren().addAll(tabs, contents);

        // Add all to Screen box
        screen.getChildren().addAll(titleBar, boxTabsContents);

        Scene scene = new Scene(screen);
        setStage(primaryStage, scene);
    }

    ////////////////////////////////////////////////////////
    // SETTING METHODS
    ////////////////////////////////////////////////////////

    // Settings for Primary Stage
    private void setStage(Stage primaryStage, Scene scene) {
        primaryStage.setTitle(APP_TITLE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Layout settings for Title Bar
    private void setTitleBar() {
        // Set properties for Title Bar
        titleBar.setPadding(new Insets(0,0,0,10));
        titleBar.getChildren().addAll(title, username, logOut);
        titleBar.setMinSize(WIDTH, TITLE_BAR_HEIGHT);
        titleBar.setStyle("-fx-background-color: #2196f3");

        // Set properties for Title
        title.setMinSize(1000, TITLE_BAR_HEIGHT);
        title.setFont(Font.font(30));
        title.setStyle("-fx-font-weight: bold");

        // Set properties for Username
        username.setMinSize(140, TITLE_BAR_HEIGHT);
        username.setFont(Font.font(20));

        // Set properties for Log Out button
        logOut.setMinSize(140, TITLE_BAR_HEIGHT);
        logOut.setFont(Font.font(20));
        logOut.setStyle("-fx-background-color: transparent");
    }

    // Layout settings for Tabs Column
    private void setTabsColumn() {
        // Set properties for Tabs box
        tabs.getChildren().addAll(home, order, receiver, deliver, statistics, map);
        tabs.setMaxWidth(TAB_WIDTH);
        tabs.setMinHeight(HEIGHT - TITLE_BAR_HEIGHT);
        tabs.setStyle("-fx-background-color: #bababa");
        tabs.setPadding(new Insets(0,SPACING,0,SPACING));

        //set properties for Tab Buttons
        setPropertiesTabButton(home);
        setPropertiesTabButton(order);
        setPropertiesTabButton(receiver);
        setPropertiesTabButton(deliver);
        setPropertiesTabButton(statistics);
        setPropertiesTabButton(map);
    }

    // Settings for buttons in Tabs Column
    private void setPropertiesTabButton(Button button) {
        button.setMinSize(TAB_WIDTH, TAB_HEIGHT);
        button.setStyle("-fx-background-color: transparent");
        button.setFont(Font.font(20));
        button.setGraphicTextGap(SPACING);
        button.setAlignment(Pos.CENTER_LEFT);
    }

    ////////////////////////////////////////////////////////
    // OTHER METHODS
    ////////////////////////////////////////////////////////

    // Get images from resources using img name
    static Image fetchImg(String imgName) {
        return new Image("file:src/image/" + imgName, ICON_DIMEN, ICON_DIMEN, true, true);
    }

}
