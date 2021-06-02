import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class OrderFood {

    public static void show(){

        Stage window = new Stage();
        window.setTitle("Order Food");
        window.setMinWidth(820);
        window.setMinHeight(660);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER_LEFT);

        //location
        Label locationLabel = new Label("Your location ");
        GridPane.setConstraints(locationLabel, 0, 11);

        ChoiceBox<String> inputLocation = new ChoiceBox<>();
        inputLocation.getItems().addAll("Badda", "Dhanmondi", "Farmgate", "Khilgaon", "Lalbagh",
                "Mirpur", "Uttara", "Zigatala");
        GridPane.setConstraints(inputLocation, 1, 11);
        inputLocation.setValue("Zigatala");

        //Food quantity textfield

        TextField inputQuantity1 = new TextField();
        inputQuantity1.setPromptText("Enter quantity");
        grid.setConstraints(inputQuantity1, 3, 12);

        TextField inputQuantity2 = new TextField();
        inputQuantity2.setPromptText("Enter quantity");
        grid.setConstraints(inputQuantity2, 3, 13);

        TextField inputQuantity3 = new TextField();
        inputQuantity3.setPromptText("Enter quantity");
        grid.setConstraints(inputQuantity3, 3, 14);

        TextField inputQuantity4 = new TextField();
        inputQuantity4.setPromptText("Enter quantity");
        grid.setConstraints(inputQuantity4, 3, 15);

        TextField inputQuantity5 = new TextField();
        inputQuantity5.setPromptText("Enter quantity");
        grid.setConstraints(inputQuantity5, 3, 16);

        TextField inputQuantity6 = new TextField();
        inputQuantity6.setPromptText("Enter quantity");
        grid.setConstraints(inputQuantity6, 3, 17);

        TextField inputQuantity7 = new TextField();
        inputQuantity7.setPromptText("Enter quantity");
        grid.setConstraints(inputQuantity7, 3, 18);

        TextField inputQuantity8 = new TextField();
        inputQuantity8.setPromptText("Enter quantity");
        grid.setConstraints(inputQuantity8, 3, 19);

        TextField inputQuantity9 = new TextField();
        inputQuantity9.setPromptText("Enter quantity");
        grid.setConstraints(inputQuantity9, 3, 20);


        //Available foods
        Label foodLabel = new Label("Available foods: ");
        GridPane.setConstraints(foodLabel, 0, 12);

        CheckBox inputFood1 = new CheckBox("Biriyani");
        GridPane.setConstraints(inputFood1, 1, 12);
        inputFood1.setOnAction( e -> GetFoodQuantity.getQuantity(grid, inputFood1, inputQuantity1));

        CheckBox inputFood2 = new CheckBox("Burger");
        GridPane.setConstraints(inputFood2, 1, 13);
        inputFood2.setOnAction( e -> GetFoodQuantity.getQuantity(grid, inputFood2, inputQuantity2));

        CheckBox inputFood3 = new CheckBox("Drinks");
        GridPane.setConstraints(inputFood3, 1, 14);
        inputFood3.setOnAction( e -> GetFoodQuantity.getQuantity(grid, inputFood3, inputQuantity3));

        CheckBox inputFood4 = new CheckBox("FrenchFries");
        GridPane.setConstraints(inputFood4, 1, 15);
        inputFood4.setOnAction( e -> GetFoodQuantity.getQuantity(grid, inputFood4, inputQuantity4));

        CheckBox inputFood5 = new CheckBox("LunchItems");
        GridPane.setConstraints(inputFood5, 1, 16);
        inputFood5.setOnAction( e -> GetFoodQuantity.getQuantity(grid, inputFood5, inputQuantity5));

        CheckBox inputFood6 = new CheckBox("Mejban");
        GridPane.setConstraints(inputFood6, 1, 17);
        inputFood6.setOnAction( e -> GetFoodQuantity.getQuantity(grid, inputFood6, inputQuantity6));

        CheckBox inputFood7 = new CheckBox("Pasta");
        GridPane.setConstraints(inputFood7, 1, 18);
        inputFood7.setOnAction( e -> GetFoodQuantity.getQuantity(grid, inputFood7, inputQuantity7));

        CheckBox inputFood8 = new CheckBox("Pastry");
        GridPane.setConstraints(inputFood8, 1, 19);
        inputFood8.setOnAction( e -> GetFoodQuantity.getQuantity(grid, inputFood8, inputQuantity8));

        CheckBox inputFood9 = new CheckBox("Pizza");
        grid.setConstraints(inputFood9, 1, 20);
        inputFood9.setOnAction( e -> GetFoodQuantity.getQuantity(grid, inputFood9, inputQuantity9));

        //search button
        Button searchButton = new Button("Search");
        grid.setConstraints(searchButton, 1, 22);
        searchButton.setOnAction( e -> {
            MakeSearchData.makeData(inputLocation, inputFood1, inputFood2,
                    inputFood3, inputFood4, inputFood5, inputFood6, inputFood7, inputFood8, inputFood9,
                    inputQuantity1, inputQuantity2, inputQuantity3, inputQuantity4, inputQuantity5, inputQuantity6, inputQuantity7,
                    inputQuantity8, inputQuantity9);

            //AdminMenu.show();
            SearchMaching.matching();
            FoundFood.show();
            window.close();
        });

        //Add buttons
        grid.getChildren().addAll(locationLabel, inputLocation, foodLabel, inputFood1, inputFood2,
                inputFood3, inputFood4, inputFood5, inputFood6, inputFood7, inputFood8, inputFood9, searchButton);


        Scene scene = new Scene(grid);
        window.setScene(scene);
        scene.getStylesheets().add("OrderFoodPage.css");
        window.showAndWait();
        window.setResizable(false);
    }
}
