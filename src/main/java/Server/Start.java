package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Start {

    public static int DEFAULT_PORT = 4214;
    public static final String IP = "localhost";

    private static ServerSocket serverSocket;
    private static final Distributor distributor = new Distributor();


    public static void main (String[] args) {

        try {
            serverSocket = new ServerSocket(DEFAULT_PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread distributorThread = new Thread(distributor);
        distributorThread.start();

        while (!Thread.interrupted()) {
            try {
                System.out.println("START: Waiting");
                Socket clientSocket = serverSocket.accept();
                System.out.println("START: Connection made at " + clientSocket.getLocalAddress());
                Thread thread = new Thread(new ClientConnection(clientSocket, distributor)); //Make new thread to handle text input from client
                thread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Server closed");
    }
}
