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
}
