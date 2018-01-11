// - Get timestamp: https://www.mkyong.com/java/how-to-get-current-timestamps-in-java/

package supportClass;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.sql.Timestamp;

import static GUI.Main.ICON_DIMEN;
import static GUI.Main.SPACING;
import static GUI.Main.fetchImg;

public class Notifications {
    //------------------------------------------------------
    // PROPERTIES
    //------------------------------------------------------

    // Properties of object
    private String title;
    private String timestamp;
    private String type;

    // Display elements
    private Image icon;
    private GridPane grid;
    private Label labelTitle, labelTime;

    //------------------------------------------------------
    // METHODS
    //------------------------------------------------------

    // Initialise all properties
    public Notifications(String title, String type) {
        this.title = title;
        this.timestamp = new Timestamp(System.currentTimeMillis()).toString();
        this.type = type;

        grid = new GridPane();

        labelTitle = new Label(title);
        labelTime = new Label(timestamp);

        // Set icon according to the type of notification
        if (type.equals("input"))
            icon = fetchImg("ic_receiver.png");
        else if (type.equals("output"))
            icon = fetchImg("ic_deliver.png");
        else if (type.equals("map"))
            icon = fetchImg("ic_map.png");
        else if (type.equals("statistics"))
            icon = fetchImg("ic_statistics.png");
        else
            icon = fetchImg("ic_home.png");
    }

    // Prepare contents to be displayed in Main scene
    public GridPane getGrid() {
        // Each time the method is called, the contents are refreshed to avoid duplicating children
        grid.getChildren().clear();

        // ImageView to display icon
        ImageView iconView = new ImageView(icon);

        // Settings for notifications title
        labelTitle.setStyle("-fx-font-weight: bold");
        labelTitle.setFont(Font.font(20));

        // Settings for notifications time
        labelTime.setFont(Font.font(20));

        // Add icon, title, timestamp to notification grid pane
        grid.add(iconView, 0, 0, 1, 2);
        grid.add(labelTitle, 1, 0);
        grid.add(labelTime, 1, 1);

        // Settings for grid pane
        grid.setHgap(SPACING * 2);
        grid.setPadding(new Insets(0,0, 0, SPACING * 2));

        // Background color for grid pane according to its type
        if (type.equals("input") || type.equals("output"))
            grid.setStyle("-fx-background-color: #b9f6ca");
        else
            grid.setStyle("-fx-background-color: #ffcdd2");

        return grid;
    }
}
