
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AdminMenu {

    public static void show(String restaurant){

        Stage window=new Stage();


        //window = primaryStage;
        window.setTitle(restaurant);
        //Button logoutButton = new Button("Logout");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER_LEFT);
        grid.setHgap(10);
        grid.setVgap(5);

        Label restaurantName = new Label(restaurant);
        restaurantName.getStyleClass().add("label-special");

        Label foodName = new Label("Food name");
        foodName.getStyleClass().add("label-bold");
        Label quantity = new Label("Quantity");
        quantity.getStyleClass().add("label-bold");
        Label costPerUnit = new Label("Cost per unit");
        costPerUnit.getStyleClass().add("label-bold");
        Label totalCost = new Label("Total cost");
        totalCost.getStyleClass().add("label-bold");
        Label customerLocation = new Label("Customer location");
        customerLocation.getStyleClass().add("label-bold");

        Button refreshButton = new Button("Refresh");
        Button logoutButton = new Button ("Logout");
        grid.setConstraints(refreshButton, 25, 3);
        grid.setConstraints(logoutButton, 2, 3);
        grid.getChildren().addAll(logoutButton, refreshButton);

        grid.setConstraints(restaurantName, 2,10);
        grid.setConstraints(foodName, 3,14);
        grid.setConstraints(quantity, 5,14);
        grid.setConstraints(costPerUnit, 7,14);
        grid.setConstraints(totalCost, 9,14);
        grid.setConstraints(customerLocation, 11,14);

        grid.getChildren().addAll(restaurantName, foodName, quantity, costPerUnit, totalCost, customerLocation);

        int yCoordinate = 17;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(restaurant + ".txt"));
            while (true) {

                String customerLocationString = reader.readLine();
                if(customerLocationString == null) break;
                String foodNameString = reader.readLine();
                String temp = reader.readLine();
                //System.out.println(temp);
                //System.out.println("haha");
                int quantityInt = Integer.parseInt(temp);
                int costPerUnitInt = Integer.parseInt(reader.readLine());
                int totalCostInt = quantityInt*costPerUnitInt;

                Label tempFoodName = new Label(foodNameString);
                Label tempQuantity = new Label(Integer.toString(quantityInt));
                Label tempCostPerUnit = new Label(Integer.toString(costPerUnitInt));
                Label tempTotalCost = new Label(Integer.toString(totalCostInt));
                Label tempCustomerLocation = new Label(customerLocationString);

                grid.setConstraints(tempFoodName, 3,yCoordinate);
                grid.setConstraints(tempQuantity, 5,yCoordinate);
                grid.setConstraints(tempCostPerUnit, 7, yCoordinate);
                grid.setConstraints(tempTotalCost, 9, yCoordinate);
                grid.setConstraints(tempCustomerLocation, 11, yCoordinate);

                yCoordinate += 1;

                grid.getChildren().addAll(tempFoodName, tempQuantity, tempCostPerUnit, tempTotalCost, tempCustomerLocation);

            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        logoutButton.setOnAction( e -> {

            Login.show();
            window.close();
        });

        refreshButton.setOnAction(e -> {

            AdminMenu.show(restaurant);
            window.close();
        });


        Scene openLocation = new Scene(grid, 800, 600);
        openLocation.getStylesheets().add("PaymentOptionPage.css");
        window.setScene(openLocation);
        window.show();
        window.setResizable(false);
    }
}
