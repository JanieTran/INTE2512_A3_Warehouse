package GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.awt.*;


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

    private final int STROKE_WIDTH = 1;
    private final int RECT_WIDTH = 150;
    private final int RECT_HEIGHT = 40;



    @Override
    public void start(Stage primaryStage) throws Exception {

        // Login Layout
        // Images
        Image imgUser = new Image("image/ic_user.png");
        Image imgPassword = new Image("image/ic_password.png");
        Image imgLogin = new Image("image/ic_login.png");

        ImageView imgVUser = new ImageView();
        imgVUser.setImage(imgUser);
        imgVUser.setFitWidth(25);
        imgVUser.setFitHeight(25);
        imgVUser.setPreserveRatio(true);
        imgVUser.setSmooth(true);
        imgVUser.setCache(true);

        ImageView imgVPassword = new ImageView();
        imgVPassword.setImage(imgPassword);
        imgVPassword.setFitWidth(25);
        imgVPassword.setFitHeight(25);
        imgVPassword.setPreserveRatio(true);
        imgVPassword.setSmooth(true);
        imgVPassword.setCache(true);

        ImageView imgVLogin = new ImageView();
        imgVLogin.setImage(imgLogin);
        imgVLogin.setFitWidth(100);
        imgVLogin.setFitHeight(100);
        imgVLogin.setPreserveRatio(true);
        imgVLogin.setSmooth(true);
        imgVLogin.setCache(true);

        // Grid layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(SPACING);
        grid.setVgap(SPACING);
        grid.setPadding(new Insets(PADDING, PADDING, PADDING, PADDING));


        // Rectangle
        Rectangle rect = new Rectangle(200,200);
        rect.setFill(Color.LIGHTGREY);
        grid.add(rect, 0, 0,3,14);


        // Login Icon
        HBox hbImgLogin = new HBox(SPACING);
        hbImgLogin.setAlignment(Pos.BOTTOM_CENTER);
        hbImgLogin.getChildren().add(imgVLogin);
        grid.add(hbImgLogin, 0, 1,3,1);

        // User name
        grid.add(imgVUser, 0, 4);
        TextField txtUserName = new TextField();
        txtUserName.setPromptText(USER_NAME_HINT);
        grid.add(txtUserName, 1, 4);

        // User password
        grid.add(imgVPassword, 0, 5);
        TextField txtPassword = new TextField();
        txtPassword.setPromptText(USER_PASSWORD_HINT);
        grid.add(txtPassword, 1, 5);


        // Login button
        Button btnLogin = new Button("Sign in");
        HBox hbLogin = new HBox(SPACING);
        hbLogin.setAlignment(Pos.BOTTOM_CENTER);
        hbLogin.getChildren().add(btnLogin);
        grid.add(hbLogin, 0, 7,3,1);

        // Map Layout
        VBox vbMap1 = new VBox(0);

        Rectangle rectMap1 = new Rectangle();
        Rectangle rectMap2 = new Rectangle();
        Rectangle rectMap3 = new Rectangle();
        Rectangle rectMap4 = new Rectangle();
        Rectangle rectMap5 = new Rectangle();

        createRect(rectMap1);
        createRect(rectMap2);
        createRect(rectMap3);
        createRect(rectMap4);
        createRect(rectMap5);

        Label lblA = new Label("A");

        vbMap1.getChildren().addAll(lblA,rectMap1,rectMap2,rectMap3,rectMap4,rectMap5);
        vbMap1.setPadding(new Insets(PADDING,PADDING,PADDING,PADDING));

        // Stage
        window = primaryStage;
        window.setTitle(WINDOW_TITLE);
        Scene sceneLogin = new Scene(grid, WINDOW_WIDTH, WINDOW_HEIGHT);
        Scene sceneMap = new Scene(vbMap1,1280,720);
        window.setScene(sceneLogin);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void createRect(Rectangle rectMap){
        rectMap.setHeight(RECT_HEIGHT);
        rectMap.setWidth(RECT_WIDTH);
        rectMap.setFill(Color.GREEN);
        rectMap.setStroke(Color.GRAY);
        rectMap.setStrokeWidth(STROKE_WIDTH);
    }
}
