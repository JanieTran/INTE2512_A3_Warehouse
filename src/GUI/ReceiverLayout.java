package GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class ReceiverLayout extends Application {
    Stage window;

    //properties
    public static void main(String[] args) {
        launch(args);
    }

    private Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Receiver Layout");

        // public Scene getScene() {
        //layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(30, 30, 30, 30));
        grid.setHgap(10);
        grid.setVgap(10);

        //name product name
        Label name = new Label("ABC1234");
        GridPane.setConstraints(name, 0, 0);

        Rectangle rFull = new Rectangle(50, 50, 300, 20);
//        rFull.setWidth(300);
//        rFull.setHeight(30);
        GridPane.setConstraints(rFull, 1, 0);

        Rectangle rPercentage = new Rectangle();
        rFull.setFill(Color.GRAY);

        rPercentage.setWidth(250);
        rPercentage.setHeight(20);
        rPercentage.setFill(Color.ORANGE);
        GridPane.setConstraints(rPercentage, 1, 0);

        grid.getChildren().addAll(name, rFull, rPercentage);
        Scene scene = new Scene(grid, 800, 500);

        window.setScene(scene);
        window.show();
        //return scene;
    }
}
