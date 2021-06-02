import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveInfo {

    public static void save(TextField inputName, ChoiceBox inputLocation, CheckBox inputFood1, CheckBox inputFood2,
                                CheckBox inputFood3, CheckBox inputFood4, CheckBox inputFood5, CheckBox inputFood6,
                                CheckBox inputFood7, CheckBox inputFood8, CheckBox inputFood9,
                                TextField inputPrice1, TextField inputPrice2, TextField inputPrice3, TextField inputPrice4,
                                TextField inputPrice5, TextField inputPrice6, TextField inputPrice7, TextField inputPrice8,
                                TextField inputPrice9) {
        int countFood = 0;
        if (inputFood1.isSelected()) countFood++;
        if (inputFood2.isSelected()) countFood++;
        if (inputFood3.isSelected()) countFood++;
        if (inputFood4.isSelected()) countFood++;
        if (inputFood5.isSelected()) countFood++;
        if (inputFood6.isSelected()) countFood++;
        if (inputFood7.isSelected()) countFood++;
        if (inputFood8.isSelected()) countFood++;
        if (inputFood9.isSelected()) countFood++;

        String ans = "";
        ans += inputName.getText() + " " + inputLocation.getValue() + " " + countFood + "\n";

        if (inputFood1.isSelected()) {
            ans += inputFood1.getText() + " " + inputPrice1.getText() + "\n";
        }
        if (inputFood2.isSelected()) {
            ans += inputFood2.getText() + " " + inputPrice2.getText() + "\n";
        }
        if (inputFood3.isSelected()) {
            ans += inputFood3.getText() + " " + inputPrice3.getText() + "\n";
        }
        if (inputFood4.isSelected()) {
            ans += inputFood4.getText() + " " + inputPrice4.getText() + "\n";
        }
        if (inputFood5.isSelected()) {
            ans += inputFood5.getText() + " " + inputPrice5.getText() + "\n";
        }
        if (inputFood6.isSelected()) {
            ans += inputFood6.getText() + " " + inputPrice6.getText() + "\n";
        }
        if (inputFood7.isSelected()) {
            ans += inputFood7.getText() + " " + inputPrice7.getText() + "\n";
        }
        if (inputFood8.isSelected()) {
            ans += inputFood8.getText() + " " + inputPrice8.getText() + "\n";
        }
        if (inputFood9.isSelected()) {
            ans += inputFood9.getText() + " " + inputPrice9.getText() + "\n";
        }

        //print info
        //System.out.println(ans);
        FileWriter fw = null;
        FileWriter fw2 = null;
        try {
            fw = new FileWriter("RestaurantInfo.txt");
            fw2 = new FileWriter("TotalData.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter output = new PrintWriter(bw);
        output.print(ans);

        BufferedWriter bw2 = new BufferedWriter(fw2);
        PrintWriter output2 = new PrintWriter(bw2);
        output2.print(ans);

        //close
        output.close();
        output2.close();
        //bw.close();
        // fw.close();
    }
}
