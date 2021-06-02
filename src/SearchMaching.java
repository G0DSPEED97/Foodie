import java.io.*;
import java.util.StringTokenizer;

public class SearchMaching {

    public static void matching() {

        CopyFile.copy("TotalData.txt", "TempData1.txt");
        String customerPlace;
        int countSearchedFood, countFound;
        String answer = "",  tempAnswer = "";


        BufferedReader readerSearchData;
        BufferedReader readerTempData1;

        try {
            readerSearchData = new BufferedReader(new FileReader("SearchData.txt"));


            String lineSearchData = readerSearchData.readLine();
            answer += lineSearchData + "\n";
            String lineTempData1;

            StringTokenizer st = new StringTokenizer( lineSearchData," ");

            customerPlace = st.nextToken();
            countSearchedFood = Integer.parseInt(st.nextToken());

            while (countSearchedFood>0) {

                readerTempData1 = new BufferedReader(new FileReader("TempData1.txt"));
                lineSearchData = "";
                lineSearchData = readerSearchData.readLine();
                answer += lineSearchData + " ";

                StringTokenizer st2 = new StringTokenizer( lineSearchData," ");
                String nameOfFoodSearched = st2.nextToken();
                countFound = 0;
                String howMany = st2.nextToken();


                while(true){

                    lineTempData1 = readerTempData1.readLine();
                    if( lineTempData1 == null) break;
                    StringTokenizer st3 = new StringTokenizer(lineTempData1," ");
                    String restaurentName, restaurentPlace;
                    int countAvailableFood;
                    restaurentName = st3.nextToken();
                    restaurentPlace = st3.nextToken();
                    countAvailableFood = Integer.parseInt(st3.nextToken());

                    while(countAvailableFood > 0){

                        lineTempData1 = "";
                        lineTempData1 = readerTempData1.readLine();
                        StringTokenizer st4 = new StringTokenizer( lineTempData1," ");
                        String foodName = st4.nextToken();
                        int foodPrice = Integer.parseInt(st4.nextToken());
                        if(foodName.equals(nameOfFoodSearched)) {

                            tempAnswer += restaurentName + " " + restaurentPlace + " " + foodPrice + "\n";
                            countFound += 1;
                        }

                        countAvailableFood -= 1;
                    }



                }

                answer += countFound + "\n";
                answer += tempAnswer;
                tempAnswer = "";
                readerTempData1.close();

                countSearchedFood -= 1;
            }
            readerSearchData.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        //System.out.println(answer);

        FileWriter fw = null;
        try {

            fw = new FileWriter("SearchResult.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter output = new PrintWriter(bw);
        output.print(answer);

        //close
        output.close();

    }
}
