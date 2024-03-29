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

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import supportClass.User;

public class Main extends Application {
    //------------------------------------------------------
    // PROPERTIES
    //------------------------------------------------------

    // Int constants
    public static final int WIDTH = 1400;
    public static final int HEIGHT = 720;
    public static final int TITLE_BAR_HEIGHT = 50;
    public static final int TAB_WIDTH = 250;
    public static final int TAB_HEIGHT = 80;
    public static final int SPACING = 20;
    public static final int ICON_DIMEN = 35;

    // String constants
    static final String APP_TITLE = "Warehouse Management";
    static final String NO_NOTIFICATION = "There is currently no notification";
    static final String NO_ORDER = "There is currently no order";

    // Screen box
    private VBox screen = new VBox();

    // Objects for title bar: title label, username label, log out button
    private HBox titleBar = new HBox();
    private Label title = new Label(APP_TITLE);

    private Image ic_user = fetchImg("ic_user.png");
    private Button username = new Button("Username", new ImageView(ic_user));

    private Button logOut = new Button("Log Out");

    // Tab buttons + icons
    private VBox tabs = new VBox();

    private Image ic_home = fetchImg("ic_home.png");
    private Button home = new Button("Home", new ImageView(ic_home));

    private Image ic_order = fetchImg("ic_order.png");
    private Button order = new Button("Order", new ImageView(ic_order));

    private Image ic_receiver = fetchImg("ic_receiver.png");
    private Button receiver = new Button("Receiver", new ImageView(ic_receiver));

    private Image ic_deliver = fetchImg("ic_deliver.png");
    private Button deliver = new Button("Deliver", new ImageView(ic_deliver));

    private Image ic_statistics = fetchImg("ic_statistics.png");
    private Button statistics = new Button("Statistics", new ImageView(ic_statistics));

    private Image ic_map = fetchImg("ic_map.png");
    private Button map = new Button("Map", new ImageView(ic_map));

    // Contents
    private HBox boxTabsContents = new HBox();
    private Pane contents = new Pane();
    private LoginLayout loginLayout = new LoginLayout();
    private TabHome tabHome = new TabHome();
    private TabOrder tabOrder = new TabOrder();
    private TabStatistics tabStatistics = new TabStatistics();
    private TabReceiver tabReceiver = new TabReceiver();
    private TabDeliver tabDeliver = new TabDeliver();
    private TabMap tabMap = new TabMap();

    //------------------------------------------------------
    // MAIN FUNCTION
    //------------------------------------------------------

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Refresh the screen and set to appropriate size
        screen.getChildren().clear();
        screen.setMinSize(WIDTH, HEIGHT);

        // Default screen is Log In screen
        screen.getChildren().add(loginLayout.getScreenLogin());

        // When Log In button is clicked, check if username and password is correct
        // If yes, switch to Main screen
        loginLayout.getBtnLogin().setOnMouseClicked(event -> {
            String userName = loginLayout.getTxtUserName().getText().toString();
            String password = loginLayout.getTxtPassword().getText().toString();

            for (User user : loginLayout.getUsers()) {
                if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                    screen.getChildren().clear();
                    screen.getChildren().addAll(titleBar, boxTabsContents);
                    username.setText(userName);
                    break;
                }
            }
        });

        // When Log Out button is clicked, return to Log In screen
        logOut.setOnMouseClicked(event -> {
            screen.getChildren().clear();
            screen.getChildren().add(loginLayout.getScreenLogin());
        });

        // Set Title Bar
        setTitleBar();

        // Tabs column
        setTabsColumn();

        // Box containing tabs column and tab contents
        // Default tab when initialised is tab Home
        contents.getChildren().clear();
        contents.getChildren().add(tabHome.getTabHome());
        chosenTab(home);

        // Event listener for each tab button
        // When a tab is clicked, that tab is highlighted and contents is fetched from
        // corresponding class

        home.setOnMouseClicked(event -> {
            chosenTab(home);
            contents.getChildren().clear();
            contents.getChildren().add(tabHome.getTabHome());
        });

        order.setOnMouseClicked(event -> {
            chosenTab(order);
            contents.getChildren().clear();
            contents.getChildren().add(tabOrder.getTabOrder());
        });

        receiver.setOnMouseClicked(event -> {
            chosenTab(receiver);
            contents.getChildren().clear();
            contents.getChildren().add(tabReceiver.getTabReceiver());

        });

        deliver.setOnMouseClicked(event -> {
            chosenTab(deliver);
            contents.getChildren().clear();
            contents.getChildren().add(tabDeliver.getTabDeliver());
        });

        statistics.setOnMouseClicked(event -> {
            chosenTab(statistics);
            contents.getChildren().clear();
            contents.getChildren().add(tabStatistics.getTabStatistics());
        });

        map.setOnMouseClicked(event -> {
            chosenTab(map);
            contents.getChildren().clear();
            contents.getChildren().add(tabMap.getTabMap());
        });

        // Settings for HBox containing tab column and contents
        boxTabsContents.setMinSize(WIDTH, HEIGHT - TITLE_BAR_HEIGHT);
        boxTabsContents.getChildren().addAll(tabs, contents);

        Scene scene = new Scene(screen);
        setStage(primaryStage, scene);
    }

    //------------------------------------------------------
    // SETTING METHODS
    //------------------------------------------------------

    // Settings for Primary Stage
    private void setStage(Stage primaryStage, Scene scene) {
        primaryStage.setTitle(APP_TITLE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Layout settings for Title Bar
    private void setTitleBar() {
        // Set properties for Title Bar
        titleBar.setPadding(new Insets(0, 0, 0, 10));
        titleBar.getChildren().addAll(title, username, logOut);
        titleBar.setMinSize(WIDTH, TITLE_BAR_HEIGHT);
        titleBar.setStyle("-fx-background-color: #2196f3");

        // Set properties for Title
        title.setMinSize(1000, TITLE_BAR_HEIGHT);
        title.setFont(Font.font(30));
        title.setStyle("-fx-font-weight: bold");

        // Set properties for Username
        username.setStyle("-fx-background-color: transparent");
        username.setMinSize(140, TITLE_BAR_HEIGHT);
        username.setFont(Font.font(20));
        username.setGraphicTextGap(SPACING / 2);

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
        tabs.setStyle("-fx-background-color: #e0e0e0");
    }

    // Settings for buttons in Tabs Column
    private void setTabButton(Button button) {
        button.setMinSize(TAB_WIDTH, TAB_HEIGHT);
        button.setStyle("-fx-background-color: transparent");
        button.setFont(Font.font(20));
        button.setGraphicTextGap(SPACING);
        button.setAlignment(Pos.CENTER_LEFT);
        button.setPadding(new Insets(0, 0, 0, SPACING * 2));
    }

    //------------------------------------------------------
    // OTHER METHODS
    //------------------------------------------------------

    // Get images from resources using image name name
    public static Image fetchImg(String imgName) {
        return new Image("file:src/image/" + imgName, ICON_DIMEN, ICON_DIMEN, true, true);
    }

    // Highlight chosen tab
    private void chosenTab(Button button) {
        setTabButton(home);
        setTabButton(order);
        setTabButton(receiver);
        setTabButton(deliver);
        setTabButton(statistics);
        setTabButton(map);
        button.setStyle("-fx-background-color: #c0c0c0");
    }

}