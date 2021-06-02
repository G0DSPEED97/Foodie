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

import javax.xml.soap.Text;
import java.io.*;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;

public class PaymentOption {

    public static void show(){

        Stage window= new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(800);
        window.setMinHeight(600);
        window.setTitle("Found Food");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER_LEFT);

        FileWriter fw = null;
        try {

            fw = new FileWriter("PaymentInfo.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter output = new PrintWriter(bw);

        int yCoordinate=0, totalPrice = 0;
        String answer = "";

        Label locationLabel = new Label("Your location: ");
        grid.setConstraints(locationLabel, 0, yCoordinate);
        yCoordinate +=3 ;

        Label orderedFoodLabel = new Label("Ordered Food: ");
        grid.setConstraints(orderedFoodLabel, 0, yCoordinate);
        yCoordinate += 3;

        Label nameLabel = new Label("Name");
        grid.setConstraints(nameLabel, 0, yCoordinate);
        Label orderPlaceLabel = new Label("Restaurant");
        grid.setConstraints(orderPlaceLabel, 1, yCoordinate);
        Label quantityLabel = new Label("Quantity");
        grid.setConstraints(quantityLabel, 2, yCoordinate);
        Label priceLabel = new Label("Price(1pcs)");
        grid.setConstraints(priceLabel, 3, yCoordinate);
        Label finalPriceLabel = new Label("Price");
        grid.setConstraints(finalPriceLabel, 4, yCoordinate);
        yCoordinate += 2;

        grid.getChildren().addAll(locationLabel, orderedFoodLabel, nameLabel, quantityLabel, priceLabel,
                finalPriceLabel, orderPlaceLabel);


        BufferedReader reader;
        try {
            //ReadyFiles.makeItEmpty("TempPayment.txt");
            reader = new BufferedReader(new FileReader("TempPayment.txt"));

            String location = reader.readLine();
            //answer += location + "\n";

            Label myLocationLabel = new Label(location);
            grid.setConstraints(myLocationLabel, 1, 0);
            grid.getChildren().add(myLocationLabel);

            while(true){

                String line = reader.readLine();
                if(line == null) break;

                StringTokenizer st = new StringTokenizer(line, " ");

                Label name = new Label(st.nextToken());
                grid.setConstraints(name, 0, yCoordinate);
                Label orderPlace = new Label(st.nextToken());
                grid.setConstraints(orderPlace, 1, yCoordinate);
                String junkRestaurantLocation = st.nextToken();
                String quantityStr = st.nextToken();
                String priceStr = st.nextToken();
                int quantityInt = Integer.parseInt(quantityStr);
                int priceInt = Integer.parseInt(priceStr);
                int finalPriceInt = quantityInt * priceInt;
                totalPrice += finalPriceInt;
                Label quantity = new Label(quantityStr);
                grid.setConstraints(quantity, 2, yCoordinate);
                Label price = new Label(priceStr);
                grid.setConstraints(price, 3, yCoordinate);
                Label finalPrice = new Label(Integer.toString(finalPriceInt));
                grid.setConstraints(finalPrice, 4, yCoordinate);

                grid.getChildren().addAll(name, orderPlace, quantity, price, finalPrice);

                yCoordinate += 1;

            }
            yCoordinate += 2;
            Label totalPriceLabel = new Label("Total Price: ");
            grid.setConstraints(totalPriceLabel, 3, yCoordinate);
            Label totalPriceInt = new Label(Integer.toString(totalPrice));
            grid.setConstraints(totalPriceInt, 4, yCoordinate);

            answer += Integer.toString(totalPrice) + "\n";

            grid.getChildren().addAll(totalPriceInt,totalPriceLabel);
            yCoordinate += 5;

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        Label choicePaymentOption = new Label("Payment Options: ");
        grid.setConstraints(choicePaymentOption, 0, yCoordinate);

        ChoiceBox<String> paymentMethod = new ChoiceBox<>();
        paymentMethod.getItems().addAll("Cash on delivery", "Bkash", "Credit Card", " ");
        GridPane.setConstraints(paymentMethod, 1, yCoordinate);
        paymentMethod.setValue(" ");
        grid. getChildren().addAll(choicePaymentOption, paymentMethod);

        final int coordinate = yCoordinate;
        output.print(answer);


        Label infoBkash = new Label("Pay your bill to 01777777777\nEnter your Tnx ID here.");
        grid.setConstraints(infoBkash, 2, coordinate);
        TextField tnxId = new TextField();
        tnxId.setPromptText("Your Tnx ID");
        grid.setConstraints(tnxId, 2, coordinate+1);

        Label infoCreditCard = new Label("Enter your pin here.");
        grid.setConstraints(infoCreditCard, 2, coordinate);
        PasswordField pin = new PasswordField();
        pin.setPromptText("Your pin");
        grid.setConstraints(pin, 2, coordinate+1);

        Label infoCash = new Label("Enter your Address here.");
        grid.setConstraints(infoCash, 2, coordinate);
        TextField address = new TextField();
        address.setPromptText("Your address");
        grid.setConstraints(address, 2, coordinate+1);

        paymentMethod.setOnAction(e -> {

            if(paymentMethod.getValue().equals("Bkash")) {

                grid.getChildren().addAll(tnxId, infoBkash);
                //output.print("Bkash" + " " + tnxId.getText() + "\n");
            }

            else if(paymentMethod.getValue().equals("Credit Card")) {

                grid.getChildren().addAll(pin, infoCreditCard);
                //output.print("CreditCard" + " " + pin.getText() + "\n");
            }

            else if(paymentMethod.getValue().equals("Cash on delivery")) {

                grid.getChildren().addAll(address, infoCash);
                //output.print("CashOnDelivery" + " " + address.getText() + "\n");
            }

        });


        Button confirmationButton = new Button("Confirm");
        grid.setConstraints(confirmationButton, 2, yCoordinate+5);
        grid.getChildren().add(confirmationButton);


        confirmationButton.setOnAction(e -> {

            if(paymentMethod.getValue().equals("Bkash")) {

                output.print("Bkash" + " " + tnxId.getText() + "\n");
            }

            else if(paymentMethod.getValue().equals("Credit Card")) {

                output.print("CreditCard" + " " + pin.getText() + "\n");
            }

            else if(paymentMethod.getValue().equals("Cash on delivery")) {

                output.print("CashOnDelivery" + " " + address.getText() + "\n");

            }
            output.close();
            AlertBox.show();
            window.close();

        });



        Scene openLocation = new Scene(grid, 800, 600);
        window.setScene(openLocation);
        openLocation.getStylesheets().add("PaymentOptionPage.css");
        window.show();
        window.setResizable(false);

    }
}
