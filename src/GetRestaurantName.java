import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GetRestaurantName {

    public static String check(String getUsername, String getPassword){

        BufferedReader reader;
        String value = "Chillox";
        try {
            reader = new BufferedReader(new FileReader("AdminData.txt"));

            while(true){

                String name = reader.readLine();
                if(name == null) break;
                String password = reader.readLine();
                String restaurantName = reader.readLine();
                if(getUsername.equals(name) && getPassword.equals(password)) {

                    value = restaurantName; break;
                }

            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}
