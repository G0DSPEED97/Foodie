import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RepairString {

    public static void repair(String str){


        FileWriter fw = null;
        FileWriter fw2 = null;
        try {

            fw = new FileWriter("FinalOrder.txt", true);
            fw2 = new FileWriter("TempPayment.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter output = new PrintWriter(bw);

        BufferedWriter bw2 = new BufferedWriter(fw2);
        PrintWriter output2 = new PrintWriter(bw2);


        String newString = "";
        StringTokenizer st = new StringTokenizer(str, " ");

        //System.out.println(st.countTokens());

        if(st.countTokens()==4){

            newString += st.nextToken() + " ";
            newString += st.nextToken() + " ";
            newString += "1 ";
            newString += st.nextToken() + "\n";
            output.print(newString);
            output2.print(newString);
        }
        else {

            output.print(str);
            output2.print(str);
        }
        output.close();
        output2.close();
    }
}
