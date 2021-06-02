import java.io.*;
import java.util.StringTokenizer;

public class UpdateRestaurantFileInfo {

    public static void update() {

        FileWriter fw1 = null;
        FileWriter fw2 = null;
        FileWriter fw3 = null;
        FileWriter fw4 = null;
        FileWriter fw5 = null;
        FileWriter fw6 = null;
        FileWriter fw7 = null;
        FileWriter fw8 = null;
        FileWriter fw9 = null;
        FileWriter fw10 = null;
        try {

            fw1 = new FileWriter("Chillox.txt");
            fw2 = new FileWriter("PastaState.txt");
            fw3 = new FileWriter("Sultan'sDine.txt");
            fw4 = new FileWriter("Takeout.txt");
            fw5 = new FileWriter("ShahiJuiceCorner.txt");
            fw6 = new FileWriter("MrBaker.txt");
            fw7 = new FileWriter("Nutrient.txt");
            fw8 = new FileWriter("TheDiningLounge.txt");
            fw9 = new FileWriter("Sbarro.txt");
            fw10 = new FileWriter("Alkaderia.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw1 = new BufferedWriter(fw1);
        PrintWriter printChillox = new PrintWriter(bw1);

        BufferedWriter bw2 = new BufferedWriter(fw2);
        PrintWriter printPastaState = new PrintWriter(bw2);

        BufferedWriter bw3 = new BufferedWriter(fw3);
        PrintWriter printSultansDine = new PrintWriter(bw3);

        BufferedWriter bw4 = new BufferedWriter(fw4);
        PrintWriter printTakeout = new PrintWriter(bw4);

        BufferedWriter bw5 = new BufferedWriter(fw5);
        PrintWriter printShahiJuiceCorner = new PrintWriter(bw5);

        BufferedWriter bw6 = new BufferedWriter(fw6);
        PrintWriter printMrBaker = new PrintWriter(bw6);

        BufferedWriter bw7 = new BufferedWriter(fw7);
        PrintWriter printNutrient = new PrintWriter(bw7);

        BufferedWriter bw8 = new BufferedWriter(fw8);
        PrintWriter printTheDiningLounge = new PrintWriter(bw8);

        BufferedWriter bw9 = new BufferedWriter(fw9);
        PrintWriter printSbarro = new PrintWriter(bw9);

        BufferedWriter bw10 = new BufferedWriter(fw10);
        PrintWriter printAlKaderia = new PrintWriter(bw10);

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("FinalOrder.txt"));
            String line = reader.readLine();
            String customerLocation = line;

            while(true) {

                line = reader.readLine();
                if(line == null) break;


                StringTokenizer st = new StringTokenizer(line, " ");
                if(st.countTokens() < 4) {

                    customerLocation = line;
                    continue;
                }
                String foodName = st.nextToken();
                String restaurantName = st.nextToken();
                String junk = st.nextToken();
                String quantity = st.nextToken();
                String pricePerUnit = st.nextToken();


                if(restaurantName.equals("Chillox")) {

                    printChillox.print(customerLocation + "\n" + foodName + "\n" + quantity + "\n" + pricePerUnit + "\n");
                }

                else if(restaurantName.equals("PastaState")) {

                    printPastaState.print(customerLocation + "\n" + foodName + "\n" + quantity + "\n" + pricePerUnit + "\n");
                }

                else if(restaurantName.equals("Sultan'sDine")) {

                    printSultansDine.print(customerLocation + "\n" + foodName + "\n" + quantity + "\n" + pricePerUnit + "\n");
                }

                else if(restaurantName.equals("Takeout")) {

                    printTakeout.print(customerLocation + "\n" + foodName + "\n" + quantity + "\n" + pricePerUnit + "\n");
                }

                else if(restaurantName.equals("ShahiJuiceCorner")) {

                    printShahiJuiceCorner.print(customerLocation + "\n" + foodName + "\n" + quantity + "\n" + pricePerUnit + "\n");
                }

                else if(restaurantName.equals("MrBaker")) {

                    printMrBaker.print(customerLocation + "\n" + foodName + "\n" + quantity + "\n" + pricePerUnit + "\n");
                }

                else if(restaurantName.equals("Nutrient")) {

                    printNutrient.print(customerLocation + "\n" + foodName + "\n" + quantity + "\n" + pricePerUnit + "\n");
                }

                else if(restaurantName.equals("TheDiningLounge")) {

                    printTheDiningLounge.print(customerLocation + "\n" + foodName + "\n" + quantity + "\n" + pricePerUnit + "\n");
                }

                else if(restaurantName.equals("Sbarro")) {

                    printSbarro.print(customerLocation + "\n" + foodName + "\n" + quantity + "\n" + pricePerUnit + "\n");
                }

                else if(restaurantName.equals("AlKaderia")) {

                    printAlKaderia.print(customerLocation + "\n" + foodName + "\n" + quantity + "\n" + pricePerUnit + "\n");
                }

                else {

                    FileWriter fww = null;
                    try {

                        fww = new FileWriter(restaurantName + ".txt");

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    BufferedWriter bw = new BufferedWriter(fww);
                    PrintWriter output = new PrintWriter(bw);

                    output.print(customerLocation + "\n" + foodName + "\n" + quantity + "\n" + pricePerUnit + "\n");
                    output.close();
                }
            }



            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        printChillox.close();
        printPastaState.close();
        printSultansDine.close();
        printTakeout.close();
        printShahiJuiceCorner.close();
        printMrBaker.close();
        printNutrient.close();
        printTheDiningLounge.close();
        printSbarro.close();
        printAlKaderia.close();
    }
}
