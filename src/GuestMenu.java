import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GuestMenu {

    public static void show(){
        Stage window=new Stage();

        Button orderFoodButton;

        //window = primaryStage;
        window.setTitle("Foodie");
        orderFoodButton = new Button("Order food");
        orderFoodButton.getStyleClass().add("button-special");

        //Logout Button
        Button logoutButton = new Button("Logout");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER_LEFT);
        grid.setConstraints(logoutButton, 1, 80);
        //grid.setConstraints(placeRestaurantButton, 1, 10);
        grid.setConstraints(orderFoodButton, 1, 43);
        grid.setHgap(10);
        grid.setVgap(5);

        orderFoodButton.setOnAction(e -> {
            OrderFood.show();
            window.close();
        });


        logoutButton.setOnAction(e -> {

            Login.show();
            window.close();
        });


        //button2.setOnAction(false);

        grid.getChildren().addAll(orderFoodButton, logoutButton);
        Scene openLocation = new Scene(grid, 800, 600);
        openLocation.getStylesheets().add("AdminMenuPage.css");
        window.setScene(openLocation);
        window.show();
        window.setResizable(false);
    }
}
