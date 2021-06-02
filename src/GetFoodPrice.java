import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.TextField;

public class GetFoodPrice {

    public static void getPrice(GridPane grid, CheckBox food, TextField inputPrice) {

        if (food.isSelected()) {

            grid.getChildren().add(inputPrice);
        }

    }
}