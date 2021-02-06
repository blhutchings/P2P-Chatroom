package Server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientConnection implements Runnable {

    private final Socket clientSocket;
    private final Distributor distributor;

    //Going to retrieve all comms from clients and put in to data base
    public ClientConnection(Socket clientSocket, Distributor distributor) {
        System.out.println("CLIENT_CONNECTION: Connection established with " + clientSocket.getInetAddress());
        this.clientSocket = clientSocket;
        this.distributor = distributor;

    }


    public void addConnectionToDistributor(PrintWriter out) {
        if (distributor != null) {
            distributor.addNewReceiver(out);
        }
    }

    public void removeConnectionToDistributor(PrintWriter out) {
        if (distributor != null) {
            distributor.addNewReceiver(out);
        }
    }



    //Continuously print stream to server
    public void run() {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
        ) {
            addConnectionToDistributor(out);
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
                distributor.relayMessage(inputLine);
            }
            removeConnectionToDistributor(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Disconnected");
    }
}
