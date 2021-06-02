import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ReadyFiles {

    public static void makeAllEmpty() {

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
        FileWriter fw11 = null;
        FileWriter fw12 = null;
        FileWriter fw13 = null;
        FileWriter fw14 = null;
        FileWriter fw15 = null;
        FileWriter fw16 = null;
        FileWriter fw17 = null;
        FileWriter fw18 = null;
        try {

            fw2 = new FileWriter("PastaState.txt");
            fw3 = new FileWriter("Sultan'sDine.txt");
            fw4 = new FileWriter("Takeout.txt");
            fw5 = new FileWriter("ShahiJuiceCorner.txt");
            fw6 = new FileWriter("MrBaker.txt");
            fw7 = new FileWriter("Nutrient.txt");
            fw8 = new FileWriter("TheDiningLounge.txt");
            fw9 = new FileWriter("Sbarro.txt");
            fw10 = new FileWriter("Alkaderia.txt");
            fw1 = new FileWriter("Chillox.txt");
            fw11 = new FileWriter("FinalOrder.txt");
            fw12 = new FileWriter("PaymentInfo.txt");
            fw13 = new FileWriter("RestaurantInfo.txt");
            fw14 = new FileWriter("SearchData.txt");
            fw15 = new FileWriter("SearchResult.txt");
            fw16 = new FileWriter("TempData1.txt");
            fw17 = new FileWriter("TempPayment.txt");
            fw18 = new FileWriter("TotalData.txt");


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

        BufferedWriter bw11 = new BufferedWriter(fw11);
        PrintWriter print11 = new PrintWriter(bw11);

        BufferedWriter bw12 = new BufferedWriter(fw12);
        PrintWriter print12 = new PrintWriter(bw12);

        BufferedWriter bw13 = new BufferedWriter(fw13);
        PrintWriter print13 = new PrintWriter(bw13);

        BufferedWriter bw14 = new BufferedWriter(fw14);
        PrintWriter print14 = new PrintWriter(bw14);

        BufferedWriter bw15 = new BufferedWriter(fw15);
        PrintWriter print15 = new PrintWriter(bw15);

        BufferedWriter bw16 = new BufferedWriter(fw16);
        PrintWriter print16 = new PrintWriter(bw16);

        BufferedWriter bw17 = new BufferedWriter(fw17);
        PrintWriter print17 = new PrintWriter(bw17);

        BufferedWriter bw18 = new BufferedWriter(fw18);
        PrintWriter print18 = new PrintWriter(bw18);

        printAlKaderia.print("");
        printChillox.print("");
        printTakeout.print("");
        printTheDiningLounge.print("");
        printPastaState.print("");
        printMrBaker.print("");
        printNutrient.print("");
        printSbarro.print("");
        printShahiJuiceCorner.print("");
        printSultansDine.print("");
        print11.print("");
        print12.print("");
        print13.print("");
        print14.print("");
        print15.print("");
        print16.print("");
        print17.print("");
        print18.print("");

        printAlKaderia.close();
        printChillox.close();
        printTakeout.close();
        printTheDiningLounge.close();
        printPastaState.close();
        printMrBaker.close();
        printNutrient.close();
        printSbarro.close();
        printShahiJuiceCorner.close();
        printSultansDine.close();
        print11.close();
        print12.close();
        print13.close();
        print14.close();
        print15.close();
        print16.close();
        print17.close();
        print18.close();
    }

    public static void makeItEmpty(String fileName) {

        FileWriter fw1 = null;

        try {

            fw1 = new FileWriter(fileName);



        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw1 = new BufferedWriter(fw1);
        PrintWriter output = new PrintWriter(bw1);


        output.print("");


        output.close();

    }
}
