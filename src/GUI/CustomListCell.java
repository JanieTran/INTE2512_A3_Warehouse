// http://java-buddy.blogspot.com/2013/05/implement-javafx-listview-for-custom.html
// https://www.billmann.de/2013/07/03/javafx-custom-listcell/

package GUI;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import static GUI.Main.*;

public class CustomListCell extends ListCell<Notifications> {
    GridPane grid = new GridPane();
    ImageView icon;
    Label title, subtitle;

    @Override
    protected void updateItem(Notifications noti, boolean empty) {
        super.updateItem(noti, empty);

        System.out.println("here");

        icon = new ImageView(noti.getIcon());
        title.setText(noti.getTitle());
        subtitle.setText(noti.getTimestamp());

        if (empty) {
            setText(null);
            setGraphic(null);
        }

        else {
//            setText(null);

            grid.setMinSize(WIDTH - TAB_WIDTH, HEIGHT - TITLE_BAR_HEIGHT);

            grid.setHgap(SPACING);
            grid.setVgap(SPACING);
            grid.setPadding(new Insets(0, 10, 0, 10));

            icon = new ImageView(noti.getIcon());
            grid.add(icon, 0, 0, 1, 2);

            title.setText(noti.getTitle());
            grid.add(title, 1, 0);

            subtitle.setText(noti.getTimestamp());
            grid.add(subtitle, 1, 1);

            setGraphic(grid);
        }
    }
}
