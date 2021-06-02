//import java.io.*;
//import java.net.*;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 5002;
        boolean running = true;
        ServerSocket serverSocket = new ServerSocket(port);
        while (running) {
            Socket socket = serverSocket.accept();
            ClientHandler clientHandler = new ClientHandler(socket);
            clientHandler.start();
            try {
                clientHandler.join();
                System.out.println("working");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ClientHandler extends Thread {
        private Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader fileReader, dataReceiver = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter fileWriter, dataSender = new PrintWriter(socket.getOutputStream());
                boolean running = true;
                String string = null;

                while (running) {
                    string = dataReceiver.readLine();

                    if (string.equals("AdminDataCheck")) {
                        boolean matchedFlag = false;
                        String username = dataReceiver.readLine();
                        String password = dataReceiver.readLine();
                        fileReader = new BufferedReader(new FileReader("AdminData.txt"));
                        while ((string = fileReader.readLine()) != null && !matchedFlag) {
                            if (string.equals(username)) {
                                string = fileReader.readLine();
                                if (string.equals(password)) matchedFlag = true;
                            } else fileReader.readLine();
                        }
                        if (matchedFlag) dataSender.print("OK\n");
                        else dataSender.print("NO\n");
                        dataSender.flush();
                        fileReader.close();
                        running = false;
                    } else if (string.equals("FinalOrdersList")) {
                        String placeName = dataReceiver.readLine();
                        while ((string = dataReceiver.readLine()) != null) {
                            String foodName = string;
                            String restaurantName = dataReceiver.readLine();
                            String restaurantPlace = dataReceiver.readLine();
                            int quantity = Integer.parseInt(dataReceiver.readLine());
                            int costPerUnit = Integer.parseInt(dataReceiver.readLine());
                            //PlaceOrder placeOrderObject = new PlaceOrder();
                            //placeOrderObject.func(placeName, foodName, restaurantName, restaurantPlace, quantity, costPerUnit);
                        }
                    } else if (string.equals("GetOrder")) {
                        String fileName = dataReceiver.readLine();
                        BufferedReader filReader = new BufferedReader(new FileReader(fileName));
                        while ((string = filReader.readLine()) != null) {
                            dataSender.print(string+"\n");
                        }
                        dataSender.flush();
                        filReader.close();
                    } else {
                        break;
                    }
                }

                dataSender.close();
                dataReceiver.close();
                System.out.println("working");


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}