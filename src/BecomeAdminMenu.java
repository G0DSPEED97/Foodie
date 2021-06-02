import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class BecomeAdminMenu {

    public static void show(){

        Stage window= new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(800);
        window.setMinHeight(600);
        window.setTitle("Become an admin");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.TOP_LEFT);

        Label nameLabel = new Label("Handle: ");
        Label passwordLabel = new Label("Password: ");
        Label invalidLabel = new Label("Invalid name or password");
        Label error = new Label("Both password must be same.");
        Button placeRestaurant = new Button("Place your own restaurant");

        TextField nameTextField = new TextField();
        nameTextField.setPromptText("Enter your handle name");
        TextField passwordTextField = new TextField();
        passwordTextField.setPromptText("Enter your password");
        TextField confirmPasswordTextField = new TextField();
        confirmPasswordTextField.setPromptText("Enter your password again");

        grid.setConstraints(nameTextField, 5, 20);
        grid.setConstraints(passwordTextField, 5,21);
        grid.setConstraints(confirmPasswordTextField, 5, 22);
        grid.setConstraints(nameLabel, 4 ,20);
        grid.setConstraints(passwordLabel, 4, 21);
        grid.setConstraints(invalidLabel, 5,26);
        grid.setConstraints(error, 6, 22);
        grid.setConstraints(placeRestaurant, 5, 30);

        grid.getChildren().addAll(nameLabel, passwordLabel, nameTextField, passwordTextField, confirmPasswordTextField);

        Button confirmButton = new Button("Confirm");
        grid.setConstraints(confirmButton, 5, 25);

        grid.getChildren().add(confirmButton);

        confirmButton.setOnAction(e -> {

            if(!(passwordTextField.getText().equals(confirmPasswordTextField.getText())))
                grid.getChildren().add(error);

            else if(CheckUsernamePassword.checkk(nameTextField.getText(), passwordTextField.getText()))
                grid.getChildren().add(invalidLabel);

            else {

                grid.getChildren().add(placeRestaurant);

                FileWriter fw = null;
                try {
                    fw = new FileWriter("AdminData.txt",true);
                } catch (IOException eee) {
                    eee.printStackTrace();
                }
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter output = new PrintWriter(bw);
                output.print(nameTextField.getText() + "\n" + passwordTextField.getText() + "\n");

                output.close();
            }
        });

        placeRestaurant.setOnAction(e -> {

            try{Thread.currentThread().sleep(100);} catch(Exception ee){}
            PlaceRestaurant.show("Place restaurant");

            window.close();
        });

        //TextField

        Scene openLocation = new Scene(grid, 800, 600);
        openLocation.getStylesheets().add("LoginPage.css");
        window.setScene(openLocation);
        window.show();
        window.setResizable(false);
    }
}
