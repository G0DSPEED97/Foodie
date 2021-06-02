import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.Socket;
import java.util.StringTokenizer;

public class CheckUsernamePassword {

    public static boolean check(TextField getUsername, PasswordField getPassword) {
        try {
            int port = 5002;
            Socket socket = new Socket("localhost", port);
            BufferedReader dataReceiver = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter dataSender = new PrintWriter(socket.getOutputStream());
            dataSender.print("AdminDataCheck\n" + getUsername.getText() + "\n" + getPassword.getText() + "\n");
            dataSender.flush();
            String string = dataReceiver.readLine();
            if (string.equals("OK")) return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }



    public static boolean checkk(String getUsername, String getPassword){

        BufferedReader reader;
        boolean flag = false;
        try {
            reader = new BufferedReader(new FileReader("AdminData.txt"));

            while(true){

                String name = reader.readLine();
                if(name == null) break;
                String password = reader.readLine();
                String restaurantName = reader.readLine();
                if(getUsername.equals(name) && getPassword.equals(password)) flag = true;
                //System.out.println(name+" "+password);

            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
