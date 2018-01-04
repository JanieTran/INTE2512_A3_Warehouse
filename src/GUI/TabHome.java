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

public class TabHome {
    static VBox tabHome = new VBox();
    static Label tabTitle = new Label("Notifications");
    static ListView<Notifications> notiListView = new ListView<>();
    static List<Notifications> notiList = new ArrayList<>();
    static ObservableList<Notifications> obsNotiList;
    static GridPane grid = new GridPane();

    static void generateNotiList() {
        notiList.add(new Notifications("ABC1232 Input Complete", "input"));
        notiList.add(new Notifications("Traffic Jam at Block A", "map"));
        notiList.add(new Notifications("ABC1230 Not Found at E5", "statistics"));
        notiList.add(new Notifications("XYZ1231 Output Complete", "output"));
    }

    static void getNotiListView() {
        generateNotiList();
        obsNotiList = FXCollections.observableList(notiList);

        notiListView.setItems(obsNotiList);
        notiListView.setCellFactory(new Callback<ListView<Notifications>, ListCell<Notifications>>() {
            @Override
            public ListCell<Notifications> call(ListView<Notifications> param) {
                ListCell<Notifications> cell = new ListCell<Notifications>() {
                    @Override
                    protected void updateItem(Notifications item, boolean empty) {
                        super.updateItem(item, empty);

                        ImageView icon = new ImageView(item.getIcon());
                        Label title = new Label(item.getTitle());
                        Label subtitle = new Label(item.getTimestamp());

                        if (empty) {
                            setText(null);
                            setGraphic(null);
                        }

                        else {
                            setText(null);

                            grid.setMinSize(WIDTH - TAB_WIDTH, HEIGHT - TITLE_BAR_HEIGHT);

                            grid.setHgap(SPACING);
                            grid.setVgap(SPACING);
                            grid.setPadding(new Insets(0, 10, 0, 10));

                            grid.add(icon, 0, 0, 1, 2);

                            grid.add(title, 1, 0);

                            grid.add(subtitle, 1, 1);

                            setGraphic(grid);
                        }
                    }
                };

                return cell;
            }
        });
    }

    public static VBox getTabHome() {
        getNotiListView();

        tabHome.setMinSize(WIDTH - TAB_WIDTH, HEIGHT - TITLE_BAR_HEIGHT);
        tabHome.getChildren().addAll(tabTitle, notiListView);

        return tabHome;
    }
}
