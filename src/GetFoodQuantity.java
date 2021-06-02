import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class GetFoodQuantity {

    public static void getQuantity(GridPane grid, CheckBox foodName, TextField inputQuantity){

        if (foodName.isSelected()) {

            grid.getChildren().add(inputQuantity);
        }
    }
}
