import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class AlertBox {

    public static void show() {
        Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Order confired");
        window.setMinWidth(250);

        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(5);
        layout.setHgap(5);

        Label label = new Label();
        label.setText("Your Order is in queue.");
        layout.setConstraints(label, 0 , 0);
        Button closeButton = new Button("Return to login page");
        layout.setConstraints(closeButton, 0,5);
        closeButton.setOnAction(e -> {

            Login.show();
            window.close();
        });


        layout.getChildren().addAll(label, closeButton);


        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(layout, 250, 200);
        window.setScene(scene);
        scene.getStylesheets().add("AlertBoxPage.css");
        window.showAndWait();
    }

}