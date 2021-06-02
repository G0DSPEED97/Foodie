import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.concurrent.atomic.AtomicInteger;


public class Login {


    public static void show(){

        Stage window= new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(800);
        window.setMinHeight(600);
        Button buttonAdmin;
        Button buttonGuest;

        window.setTitle("Login");
        buttonAdmin = new Button("Login as admin");
        buttonAdmin.getStyleClass().add("button-special");
        buttonGuest = new Button("Login as guest");
        buttonGuest.getStyleClass().add("button-special");

        Button buttonBecomeAdmin = new Button("Become an admin");
        buttonBecomeAdmin.getStyleClass().add("button-special");

        Label userame = new Label("Username: ");
        Label Password = new Label("Password: ");
        Label wrongInput = new Label("Username or Password error");
        wrongInput.getStyleClass().add("red-label");
        TextField getUsername = new TextField();
        PasswordField getPassword = new PasswordField();
        getUsername.setPromptText("Your username");
        getPassword.setPromptText("Your password");
        Button buttonLogin = new Button("Login");

        GridPane grid = new GridPane();
        grid.setVgap(8);
        grid.setHgap(10);

        grid.setConstraints(buttonAdmin, 22, 55);
        grid.setConstraints(buttonGuest, 26, 55);
        grid.setConstraints(buttonBecomeAdmin, 30, 55);
        grid.setConstraints(getUsername, 22, 56);
        grid.setConstraints(getPassword, 26, 56);
        grid.setConstraints(buttonLogin, 22, 57);
        grid.setConstraints(wrongInput, 22, 58);

        grid.getChildren().addAll(buttonAdmin, buttonGuest, buttonBecomeAdmin);

        buttonAdmin.setOnAction(e -> {
            //window.close();
            TakeUsernamePassword.show(grid, getUsername, getPassword, buttonLogin);
        });
        buttonGuest.setOnAction(e -> {

            GuestMenu.show();
            window.close();

        });

        buttonBecomeAdmin.setOnAction(e -> {

            BecomeAdminMenu.show();
            window.close();

        });

        AtomicInteger childrenCheck = new AtomicInteger(0);
        buttonLogin.setOnAction(e-> {
            boolean x = CheckUsernamePassword.checkk(getUsername.getText(), getPassword.getText());
            if(x == true){
                String restaurant = GetRestaurantName.check(getUsername.getText(), getPassword.getText());
                AdminMenu.show(restaurant);
                window.close();
            }
            else if(childrenCheck.get() == 0){
                grid.getChildren().add(wrongInput);
                childrenCheck.set(1);
            }
        });

        Scene openLocation = new Scene(grid, 800, 600);
        openLocation.getStylesheets().add("LoginPage.css");
        window.setScene(openLocation);
        window.show();
        window.setResizable(false);
    }

}
