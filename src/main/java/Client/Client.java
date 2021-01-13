package Client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static final Scanner STDIN = new Scanner(System.in);

    private Socket serverConnection;
    private PrintWriter clientOut;
    private Scanner clientReceive;

    public Client (String ip, int port) {
        System.out.println("Client started");
        try {
            serverConnection = new Socket(ip, port);
            clientReceive = new Scanner(serverConnection.getInputStream());
            clientOut = new PrintWriter(serverConnection.getOutputStream());
            while (true) {
                clientOut.println(STDIN.nextLine());
                clientOut.flush();
                System.out.println("Flushed");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
