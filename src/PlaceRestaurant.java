import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.control.Button;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PlaceRestaurant{

    public static boolean answer;

    public static boolean show(String title) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(820);
        window.setMinHeight(660);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);


        //Restaurant name
        Label nameLabel = new Label("Restaurant Name: ");
        GridPane.setConstraints(nameLabel, 0, 0);

        TextField inputName = new TextField();
        inputName.setPromptText("Enter your restaurant name");
        GridPane.setConstraints(inputName, 1, 0);



        //Restaurant Place
        Label locationLabel = new Label("Location: ");
        GridPane.setConstraints(locationLabel, 0, 1);

        ChoiceBox<String> inputLocation = new ChoiceBox<>();
        inputLocation.getItems().addAll("Badda", "Dhanmondi", "Farmgate", "Khilgaon", "Lalbagh",
                "Mirpur", "Uttara", "Zigatala");
        GridPane.setConstraints(inputLocation, 1, 1);
        inputLocation.setValue("Zigatala");

        //Food price textfield

        TextField inputPrice1 = new TextField();
        inputPrice1.setPromptText("Enter price");
        grid.setConstraints(inputPrice1, 3, 2);

        TextField inputPrice2 = new TextField();
        inputPrice2.setPromptText("Enter price");
        grid.setConstraints(inputPrice2, 3, 3);

        TextField inputPrice3 = new TextField();
        inputPrice3.setPromptText("Enter price");
        grid.setConstraints(inputPrice3, 3, 4);

        TextField inputPrice4 = new TextField();
        inputPrice4.setPromptText("Enter price");
        grid.setConstraints(inputPrice4, 3, 5);

        TextField inputPrice5 = new TextField();
        inputPrice5.setPromptText("Enter price");
        grid.setConstraints(inputPrice5, 3, 6);

        TextField inputPrice6 = new TextField();
        inputPrice6.setPromptText("Enter price");
        grid.setConstraints(inputPrice6, 3, 7);

        TextField inputPrice7 = new TextField();
        inputPrice7.setPromptText("Enter price");
        grid.setConstraints(inputPrice7, 3, 8);

        TextField inputPrice8 = new TextField();
        inputPrice8.setPromptText("Enter price");
        grid.setConstraints(inputPrice8, 3, 9);

        TextField inputPrice9 = new TextField();
        inputPrice9.setPromptText("Enter price");
        grid.setConstraints(inputPrice9, 3, 10);



        //Available foods
        Label foodLabel = new Label("Available foods: ");
        GridPane.setConstraints(foodLabel, 0, 2);

        CheckBox inputFood1 = new CheckBox("Biriyani");
        GridPane.setConstraints(inputFood1, 1, 2);
        inputFood1.setOnAction( e -> GetFoodPrice.getPrice(grid, inputFood1, inputPrice1));

        CheckBox inputFood2 = new CheckBox("Burger");
        GridPane.setConstraints(inputFood2, 1, 3);
        inputFood2.setOnAction( e -> GetFoodPrice.getPrice(grid, inputFood2, inputPrice2));

        CheckBox inputFood3 = new CheckBox("Drinks");
        GridPane.setConstraints(inputFood3, 1, 4);
        inputFood3.setOnAction( e -> GetFoodPrice.getPrice(grid, inputFood3, inputPrice3));

        CheckBox inputFood4 = new CheckBox("FrenchFries");
        GridPane.setConstraints(inputFood4, 1, 5);
        inputFood4.setOnAction( e -> GetFoodPrice.getPrice(grid, inputFood4, inputPrice4));

        CheckBox inputFood5 = new CheckBox("LunchItems");
        GridPane.setConstraints(inputFood5, 1, 6);
        inputFood5.setOnAction( e -> GetFoodPrice.getPrice(grid, inputFood5, inputPrice5));

        CheckBox inputFood6 = new CheckBox("Mejban");
        GridPane.setConstraints(inputFood6, 1, 7);
        inputFood6.setOnAction( e -> GetFoodPrice.getPrice(grid, inputFood6, inputPrice6));

        CheckBox inputFood7 = new CheckBox("Pasta");
        GridPane.setConstraints(inputFood7, 1, 8);
        inputFood7.setOnAction( e -> GetFoodPrice.getPrice(grid, inputFood7, inputPrice7));

        CheckBox inputFood8 = new CheckBox("Pastry");
        GridPane.setConstraints(inputFood8, 1, 9);
        inputFood8.setOnAction( e -> GetFoodPrice.getPrice(grid, inputFood8, inputPrice8));

        CheckBox inputFood9 = new CheckBox("Pizza");
        grid.setConstraints(inputFood9, 1, 10);
        inputFood9.setOnAction( e -> GetFoodPrice.getPrice(grid, inputFood9, inputPrice9));



        //Save button
        Button saveButton = new Button("Save");
        grid.setConstraints(saveButton, 1, 12);
        saveButton.setOnAction( e -> {
            SaveInfo.save(inputName, inputLocation, inputFood1, inputFood2,
                    inputFood3, inputFood4, inputFood5, inputFood6, inputFood7, inputFood8, inputFood9,
                    inputPrice1, inputPrice2, inputPrice3, inputPrice4, inputPrice5, inputPrice6, inputPrice7,
                    inputPrice8, inputPrice9);


            FileWriter fw2 = null;
            try {
                fw2 = new FileWriter("AdminData.txt",true);
            } catch (IOException eee) {
                eee.printStackTrace();
            }
            BufferedWriter bw2 = new BufferedWriter(fw2);
            PrintWriter output2 = new PrintWriter(bw2);
            output2.print(inputName.getText() + "\n");

            output2.close();


            ReadyFiles.makeItEmpty(inputName.getText() + ".txt");
            Login.show();

            window.close();
        });


        //Add buttons on screen
        grid.getChildren().addAll(nameLabel, inputName, locationLabel, inputLocation, foodLabel, inputFood1, inputFood2,
                inputFood3, inputFood4, inputFood5, inputFood6, inputFood7, inputFood8, inputFood9, saveButton);
        grid.setAlignment(Pos.CENTER_LEFT);


        FileWriter fw = null;
        try {

            fw = new FileWriter(inputName.getText()+".txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter output = new PrintWriter(bw);
        output.print("");
        output.close();

        Scene scene = new Scene(grid);
        window.setScene(scene);
        scene.getStylesheets().add("AdminMenuPage.css");
        window.showAndWait();
        window.setResizable(false);

        return answer;


    }
}