// - Get timestamp: https://www.mkyong.com/java/how-to-get-current-timestamps-in-java/

package GUI;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.sql.Timestamp;

import static GUI.Main.ICON_DIMEN;
import static GUI.Main.SPACING;

public class Notifications {
    private String title;
    private String timestamp;
    private Image icon;
    private GridPane grid = new GridPane();

    public Notifications(String title, String type) {
        this.title = title;
        this.timestamp = new Timestamp(System.currentTimeMillis()).toString();

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

    public String getTitle() {
        return title;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public Image getIcon() {
        return icon;
    }

    private Image fetchImg(String imgName) {
        return new Image("file:src/image/" + imgName, ICON_DIMEN, ICON_DIMEN, true, true);
    }

    public GridPane getGrid() {
        ImageView iconView = new ImageView(icon);
        Label labelTitle = new Label(title);
        Label labelTime = new Label(timestamp);

        labelTitle.setStyle("-fx-font-weight: bold");
        labelTitle.setFont(Font.font(20));

        labelTime.setFont(Font.font(20));

        grid.add(iconView, 0, 0, 1, 2);
        grid.add(labelTitle, 1, 0);
        grid.add(labelTime, 1, 1);

        grid.setHgap(SPACING);
        grid.setPadding(new Insets(0,0, SPACING, SPACING));

        return grid;
    }
}
