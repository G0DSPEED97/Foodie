import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;


public class TakeUsernamePassword {

    public static void show(GridPane grid, TextField getUsername, PasswordField getPassword, Button buttonLogin){

            grid.getChildren().addAll(getUsername, getPassword, buttonLogin);
            //boolean x;
            //x = CheckUsernamePassword.check(getUsername, getPassword);
            //return x;
    }
}
