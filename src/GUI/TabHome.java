package GUI;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import static GUI.Main.*;

public class TabHome {
    static VBox tabHome = new VBox();
    static Label tabTitle = new Label("NOTIFICATIONS");
    static VBox boxNoti = new VBox();

    static Notifications notiInput = new Notifications("ABC1232 Input Complete", "input");
    static Notifications notiStats = new Notifications("Traffic Jam at Block A", "map");
    static Notifications notiMap = new Notifications("ABC1230 Not Found at E5", "statistics");
    static Notifications notiOutput = new Notifications("XYZ1231 Output Complete", "output");

    public static VBox getTabHome() {
        boxNoti.getChildren().addAll(notiInput.getGrid(), notiStats.getGrid(), notiMap.getGrid(), notiOutput.getGrid());

        tabTitle.setFont(Font.font(30));
        tabTitle.setStyle("-fx-font-weight: bold");

        tabHome.getChildren().addAll(tabTitle, boxNoti);
        tabHome.setMinSize(WIDTH - TAB_WIDTH, HEIGHT - TITLE_BAR_HEIGHT);
        tabHome.setSpacing(SPACING);
        tabHome.setPadding(new Insets(SPACING, SPACING, SPACING, SPACING * 2));

        return tabHome;
    }
}
