package GUI;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import static GUI.Main.*;

public class TabOrder {
    //------------------------------------------------------
    // PROPERTIES
    //------------------------------------------------------

    private VBox tabOrder;
    private VBox boxOrder;
    private Label tabTitle;
    private Order kabylake;
    private GridPane gpOrder;

    public TabOrder() {
        tabOrder = new VBox();
        boxOrder = new VBox();
        tabTitle = new Label("ORDERS");
        kabylake = new Order("KABYLAKE", "ABC2345", 1000, "Intel", true);
        gpOrder = kabylake.getGridOrder();
    }

    public VBox getTabOrder() {
        tabOrder.getChildren().clear();

        tabTitle.setFont(Font.font(30));
        tabTitle.setStyle("-fx-font-weight: bold; -fx-text-fill: #2196f3");

        tabOrder.getChildren().addAll(tabTitle, gpOrder);
        tabOrder.setMinSize(WIDTH - TAB_WIDTH, HEIGHT - TITLE_BAR_HEIGHT);
        tabOrder.setSpacing(SPACING);
        tabOrder.setPadding(new Insets(SPACING, SPACING, SPACING, SPACING * 2));

        return tabOrder;
    }
}
