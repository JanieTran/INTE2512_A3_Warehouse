// - Get timestamp: https://www.mkyong.com/java/how-to-get-current-timestamps-in-java/

package GUI;

import javafx.scene.image.Image;

import java.sql.Timestamp;

import static GUI.Main.ICON_DIMEN;

public class Notifications {
    private String title;
    private String timestamp;
    private Image icon;

    public Notifications(String title, String type) {
        this.title = title;
        this.timestamp = new Timestamp(System.currentTimeMillis()).toString();

        switch (type) {
            case "input":
                icon = new Image("file:src/image/ic_receiver", ICON_DIMEN, ICON_DIMEN, true, true);
                break;

            case "output":
                icon = new Image("file:src/image/ic_deliver", ICON_DIMEN, ICON_DIMEN, true, true);
                break;

            case "map":
                icon = new Image("file:src/image/ic_map", ICON_DIMEN, ICON_DIMEN, true, true);
                break;

            case "statistics":
                icon = new Image("file:src/image/ic_statistics", ICON_DIMEN, ICON_DIMEN, true, true);
                break;
        }
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
}
