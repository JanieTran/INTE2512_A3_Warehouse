package GUI;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import static GUI.Main.*;

public class TabHome {
    //------------------------------------------------------
    // PROPERTIES
    //------------------------------------------------------

    static VBox tabHome = new VBox();
    static Label tabTitle = new Label("NOTIFICATIONS");
    static VBox boxNoti = new VBox();

    static Notifications notiInput = new Notifications("ABC1232 Input Complete", "input");
    static Notifications notiStats = new Notifications("Traffic Jam at Block A", "map");
    static Notifications notiMap = new Notifications("ABC1230 Not Found at E5", "statistics");
    static Notifications notiOutput = new Notifications("XYZ1231 Output Complete", "output");

    static GridPane notiInputGrid = notiInput.getGrid();
    static GridPane notiStatsGrid = notiStats.getGrid();
    static GridPane notiMapGrid = notiMap.getGrid();
    static GridPane notiOutputGrid = notiOutput.getGrid();

    static Label noNoti = new Label(NO_NOTIFICATION);

    //------------------------------------------------------
    // METHODS
    //------------------------------------------------------

    public static VBox getTabHome() {
        boxNoti.getChildren().clear();
        boxNoti.getChildren().addAll(notiInputGrid, notiStatsGrid, notiMapGrid, notiOutputGrid);

        noNoti.setFont(Font.font(20));
        noNoti.setPadding(new Insets(SPACING, SPACING, SPACING, SPACING * 2));
        noNoti.setStyle("-fx-text-fill: #ababab");

        updateTabHome();

        setGridOnClick(notiInputGrid);
        setGridOnClick(notiStatsGrid);
        setGridOnClick(notiMapGrid);
        setGridOnClick(notiOutputGrid);

        tabTitle.setFont(Font.font(30));
        tabTitle.setStyle("-fx-font-weight: bold; -fx-text-fill: #2196f3");

        tabHome.setMinSize(WIDTH - TAB_WIDTH, HEIGHT - TITLE_BAR_HEIGHT);
        tabHome.setSpacing(SPACING);
        tabHome.setPadding(new Insets(SPACING, SPACING, SPACING, SPACING * 2));

        return tabHome;
    }

    private static void setGridOnClick(GridPane grid) {
        grid.setOnMouseClicked(event -> {
            boxNoti.getChildren().remove(grid);
            updateTabHome();
        });
    }

    private static void updateTabHome() {
        tabHome.getChildren().clear();

        if (boxNoti.getChildren().isEmpty())
            tabHome.getChildren().addAll(tabTitle, noNoti);
        else
            tabHome.getChildren().addAll(tabTitle, boxNoti);
    }
}
