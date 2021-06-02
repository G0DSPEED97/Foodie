import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MakeSearchData {

    public static void makeData(ChoiceBox inputLocation, CheckBox inputFood1, CheckBox inputFood2,
                                CheckBox inputFood3, CheckBox inputFood4, CheckBox inputFood5, CheckBox inputFood6,
                                CheckBox inputFood7, CheckBox inputFood8, CheckBox inputFood9,
                                TextField inputQuantity1, TextField inputQuantity2, TextField inputQuantity3,
                                TextField inputQuantity4, TextField inputQuantity5, TextField inputQuantity6,
                                TextField inputQuantity7, TextField inputQuantity8, TextField inputQuantity9){

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
        ans += inputLocation.getValue() + " " + countFood + "\n";

        if (inputFood1.isSelected()) {
            ans += inputFood1.getText() + " " + inputQuantity1.getText() + "\n";
        }
        if (inputFood2.isSelected()) {
            ans += inputFood2.getText() + " " + inputQuantity2.getText() + "\n";
        }
        if (inputFood3.isSelected()) {
            ans += inputFood3.getText() + " " + inputQuantity3.getText() + "\n";
        }
        if (inputFood4.isSelected()) {
            ans += inputFood4.getText() + " " + inputQuantity4.getText() + "\n";
        }
        if (inputFood5.isSelected()) {
            ans += inputFood5.getText() + " " + inputQuantity5.getText() + "\n";
        }
        if (inputFood6.isSelected()) {
            ans += inputFood6.getText() + " " + inputQuantity6.getText() + "\n";
        }
        if (inputFood7.isSelected()) {
            ans += inputFood7.getText() + " " + inputQuantity7.getText() + "\n";
        }
        if (inputFood8.isSelected()) {
            ans += inputFood8.getText() + " " + inputQuantity8.getText() + "\n";
        }
        if (inputFood9.isSelected()) {
            ans += inputFood9.getText() + " " + inputQuantity9.getText() + "\n";
        }

        //print info
        //System.out.println(ans);
        FileWriter fw = null;
        try {
            fw = new FileWriter("SearchData.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter output = new PrintWriter(bw);
        output.print(ans);

        //close
        output.close();
        //bw.close();
        // fw.close();
    }
}
