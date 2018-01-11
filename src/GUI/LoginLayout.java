package GUI;

import csv.readCSV;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import supportClass.User;

import java.util.ArrayList;

import static GUI.Main.HEIGHT;
import static GUI.Main.WIDTH;

public class LoginLayout {
    private final String USERS_FILE = "src/database/users.csv";

    private final int SPACING = 15;
    private final int PADDING = 25;
    private final String USER_NAME_HINT = "Enter your name";
    private final String USER_PASSWORD_HINT = "Password";

    private VBox screenLogin;
    private Button btnLogin;
    private TextField txtUserName;
    private PasswordField txtPassword;

    private ArrayList<User> users;

    public LoginLayout() {
        screenLogin = new VBox();
        btnLogin = new Button("Sign in");
        txtUserName = new TextField();
        txtUserName.setText("admin");
        txtPassword = new PasswordField();
        txtPassword.setText("admin");

        users = readCSV.readCSVtoUser(USERS_FILE);
    }

    public VBox getScreenLogin() {
        screenLogin.getChildren().clear();

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

        // Grid pane
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

        txtUserName.setPromptText(USER_NAME_HINT);
        gridLogin.add(txtUserName, 1, 4);

        // User password
        gridLogin.add(imgVPassword, 0, 5);

        txtPassword.setPromptText(USER_PASSWORD_HINT);
        gridLogin.add(txtPassword, 1, 5);

        // Login button
        HBox hbLogin = new HBox(SPACING);
        hbLogin.setAlignment(Pos.BOTTOM_CENTER);
        hbLogin.getChildren().add(btnLogin);
        gridLogin.add(hbLogin, 0, 7, 3, 1);

        screenLogin.getChildren().add(gridLogin);
        screenLogin.setMinSize(WIDTH, HEIGHT);

        return screenLogin;
    }

    public Button getBtnLogin() {
        return btnLogin;
    }

    public TextField getTxtUserName() {
        return txtUserName;
    }

    public TextField getTxtPassword() {
        return txtPassword;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    // Create Image View
    static void createImageView(ImageView imgView, Image img, int width, int height) {
        imgView.setImage(img);
        imgView.setFitWidth(width);
        imgView.setFitHeight(height);
        imgView.setPreserveRatio(true);
        imgView.setSmooth(true);
        imgView.setCache(true);
    }

    // Create grid pane
    private void createGridLayout(GridPane gridPane) {
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(SPACING);
        gridPane.setVgap(SPACING);
        gridPane.setPadding(new Insets(PADDING, PADDING, PADDING, PADDING));
    }
}
