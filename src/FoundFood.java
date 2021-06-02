import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.xml.soap.Text;
import java.io.*;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;

public class FoundFood {

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
        FileWriter fw2 = null;
        try {

            fw = new FileWriter("FinalOrder.txt", true);
            fw2 = new FileWriter("TempPayment.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter output = new PrintWriter(bw);

        BufferedWriter bw2 = new BufferedWriter(fw2);
        PrintWriter output2 = new PrintWriter(bw2);

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("SearchResult.txt"));

            String orderInfo = reader.readLine();

            StringTokenizer stt = new StringTokenizer(orderInfo,  " ");
            String location = stt.nextToken();
            output.print(location + "\n");
            output2.print(location + "\n");
            output.close();
            output2.close();

            int yCoordinate=0;
            while(true) {

                String line = reader.readLine();
                if (line == null ) break;
                StringTokenizer st = new StringTokenizer(line, " ");
                String tempString = st.nextToken();

                if( tempString.equals("Biriyani") || tempString.equals("Burger") || tempString.equals("Drinks") ||
                        tempString.equals("FrenchFries") || tempString.equals("LunchItems") || tempString.equals("Mejban") ||
                        tempString.equals("Pasta") || tempString.equals("Pastry") || tempString.equals("Pizza") ) {

                    Label commonName = new Label(tempString);
                    grid.setConstraints(commonName, 0, yCoordinate);

                    grid.getChildren().add(commonName);


                    final String ammount = st.nextToken();
                    int countFound = Integer.parseInt(st.nextToken());

                    if(countFound == 0){


                    }

                    while(countFound > 0) {

                        line = reader.readLine();
                        StringTokenizer st2 = new StringTokenizer(line, " ");
                        String restaurantName = st2.nextToken();
                        String restaurantLocation = st2.nextToken();
                        String itemPrice = st2.nextToken();

                        Button nameButton = new Button(restaurantName);
                        grid.setConstraints(nameButton, 1, yCoordinate);
                        Label priceLabel = new Label("price: " + itemPrice);
                        grid.setConstraints(priceLabel, 2, yCoordinate);
                        TextField quantity = new TextField();
                        grid.setConstraints(quantity, 3, yCoordinate);
                        quantity.setPromptText(ammount);

                        yCoordinate += 1;
                        grid.getChildren().addAll(nameButton, priceLabel, quantity);
                        nameButton.setOnAction( e -> {

                            String finalString, temp;

                            finalString = tempString +" "+ restaurantName +" "+
                                    restaurantLocation +" "+ quantity.getText() +" "+ itemPrice+"\n";

                            RepairString.repair(finalString);

                            //output.print(finalString);

                            //window.close();
                        });

                        countFound -= 1;
                    }

                }

            }

            Button orderButton = new Button("Order");
            grid.setConstraints(orderButton, 2, yCoordinate+10);
            grid.getChildren().add(orderButton);

            orderButton.setOnAction(e -> {

                PaymentOption.show();
                UpdateRestaurantFileInfo.update();
                output.close();
                window.close();
            });

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


        Scene openLocation = new Scene(grid, 800, 600);
        window.setScene(openLocation);
        openLocation.getStylesheets().add("FoundFoodPage.css");
        window.show();
        window.setResizable(false);

    }
}
