package GUI;

import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class LoginLayout extends Application {
    private Stage window;

    //Constant variables
    private final int WINDOW_WIDTH = 400;
    private final int WINDOW_HEIGHT = 400;
    private final int SPACING = 15;
    private final int PADDING = 25;
    private final String USER_NAME_HINT = "Enter your name";
    private final String USER_PASSWORD_HINT = "Password";
    private final String WINDOW_TITLE = "LOGIN";


    @Override
    public void start(Stage primaryStage) throws Exception {

        // Login Layout
        // Images
        Image imgUser = new Image("image/ic_user.png");
        Image imgPassword = new Image("image/ic_password.png");
        Image imgLogin = new Image("image/ic_login.png");

        ImageView imgVUser = new ImageView();
        createImageView(imgVUser, imgUser, 25, 25);

        ImageView imgVPassword = new ImageView();
        createImageView(imgVPassword, imgPassword, 25, 25);

        ImageView imgVLogin = new ImageView();
        createImageView(imgVLogin, imgLogin, 100, 100);


        // Grid layout
        GridPane gridLogin = new GridPane();
        createGridLayout(gridLogin);

        // Rectangle
        Rectangle rect = new Rectangle(200, 200);
        rect.setFill(Color.LIGHTGREY);
        gridLogin.add(rect, 0, 0, 3, 14);


        // Login Icon
        HBox hbImgLogin = new HBox(SPACING);
        hbImgLogin.setAlignment(Pos.BOTTOM_CENTER);
        hbImgLogin.getChildren().add(imgVLogin);
        gridLogin.add(hbImgLogin, 0, 1, 3, 1);

        // User name
        gridLogin.add(imgVUser, 0, 4);
        TextField txtUserName = new TextField();
        txtUserName.setPromptText(USER_NAME_HINT);
        gridLogin.add(txtUserName, 1, 4);

        // User password
        gridLogin.add(imgVPassword, 0, 5);
        TextField txtPassword = new TextField();
        txtPassword.setPromptText(USER_PASSWORD_HINT);
        gridLogin.add(txtPassword, 1, 5);


        // Login button
        Button btnLogin = new Button("Sign in");
        HBox hbLogin = new HBox(SPACING);
        hbLogin.setAlignment(Pos.BOTTOM_CENTER);
        hbLogin.getChildren().add(btnLogin);
        gridLogin.add(hbLogin, 0, 7, 3, 1);

        // Stage
        window = primaryStage;
        window.setTitle(WINDOW_TITLE);
        Scene sceneLogin = new Scene(gridLogin, WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setScene(sceneLogin);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


    // Create Image View
    private void createImageView(ImageView imgView, Image img, int width, int height) {
        imgView.setImage(img);
        imgView.setFitWidth(width);
        imgView.setFitHeight(height);
        imgView.setPreserveRatio(true);
        imgView.setSmooth(true);
        imgView.setCache(true);
    }

    // Create grid layout
    private void createGridLayout(GridPane gridPane) {
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(SPACING);
        gridPane.setVgap(SPACING);
        gridPane.setPadding(new Insets(PADDING, PADDING, PADDING, PADDING));
    }




}
