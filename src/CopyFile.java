import java.io.*;
import java.util.StringTokenizer;

public class CopyFile {

    public static void copy(String from, String to){

        BufferedReader reader;
        String fileData = "";
        try {
            reader = new BufferedReader(new FileReader(from));
            String line = reader.readLine();

            while (line != null) {

                fileData+=line+"\n";
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        FileWriter fw = null;
        try {
            fw = new FileWriter(to);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter output = new PrintWriter(bw);
        output.print(fileData);
        //System.out.println(fileData);
        //close
        output.close();
    }
}
