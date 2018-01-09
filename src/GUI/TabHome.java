package GUI;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import supportClass.Notifications;

import static GUI.Main.*;

public class TabHome {
    //------------------------------------------------------
    // PROPERTIES
    //------------------------------------------------------

    private VBox tabHome = new VBox();
    private Label tabTitle = new Label("NOTIFICATIONS");
    private VBox boxNoti = new VBox();

    private Notifications notiInput = new Notifications("ABC1232 Input Complete", "input");
    private Notifications notiStats = new Notifications("Traffic Jam at Block A", "map");
    private Notifications notiMap = new Notifications("ABC1230 Not Found at E5", "statistics");
    private Notifications notiOutput = new Notifications("XYZ1231 Output Complete", "output");

    private GridPane notiInputGrid = notiInput.getGrid();
    private GridPane notiStatsGrid = notiStats.getGrid();
    private GridPane notiMapGrid = notiMap.getGrid();
    private GridPane notiOutputGrid = notiOutput.getGrid();

    private Label noNoti = new Label(NO_NOTIFICATION);

    //------------------------------------------------------
    // METHODS
    //------------------------------------------------------

    public TabHome() {

    }

    public VBox getTabHome() {
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

    private void setGridOnClick(GridPane grid) {
        grid.setOnMouseClicked(event -> {
            boxNoti.getChildren().remove(grid);
            updateTabHome();
        });
    }

    private void updateTabHome() {
        tabHome.getChildren().clear();

        if (boxNoti.getChildren().isEmpty())
            tabHome.getChildren().addAll(tabTitle, noNoti);
        else
            tabHome.getChildren().addAll(tabTitle, boxNoti);
    }
}
