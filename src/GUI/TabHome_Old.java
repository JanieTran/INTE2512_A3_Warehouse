package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.List;

import static GUI.Main.*;

public class TabHome_Old {
    static VBox tabHome = new VBox();
    static Label tabTitle = new Label("Notifications");
    static ListView<Notifications> notiListView;
    static ObservableList<Notifications> notiList = FXCollections.observableArrayList();

    static void generateNotiList() {
        notiList.add(new Notifications("ABC1232 Input Complete", "input"));
        notiList.add(new Notifications("Traffic Jam at Block A", "map"));
        notiList.add(new Notifications("ABC1230 Not Found at E5", "statistics"));
        notiList.add(new Notifications("XYZ1231 Output Complete", "output"));
    }

    static void getNotiListView() {
        generateNotiList();

        notiListView = new ListView<>(notiList);
        notiListView.setMaxWidth(WIDTH - TAB_WIDTH);
        notiListView.setItems(notiList);
        notiListView.setCellFactory(param -> new CustomListCell());
    }

    public static VBox getTabHome() {
        getNotiListView();

        tabHome.setMinSize(WIDTH - TAB_WIDTH, HEIGHT - TITLE_BAR_HEIGHT);
        tabHome.getChildren().addAll(tabTitle, notiListView);

        return tabHome;
    }
}
