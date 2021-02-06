package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static final Scanner STDIN = new Scanner(System.in);

    private Socket serverConnection;
    private PrintWriter out;
    private BufferedReader in;



    public Client (String ip, int port) {
        System.out.println("Client started");
        try {
            serverConnection = new Socket(ip, port);
            in = new BufferedReader(new InputStreamReader(serverConnection.getInputStream()));
            out = new PrintWriter(serverConnection.getOutputStream());

            new Thread(() -> {
                try {
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        System.out.println(inputLine);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();


            while (true) {
                out.println(STDIN.nextLine());
                out.flush();
                System.out.println("Flushed");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
