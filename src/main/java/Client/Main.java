package Client;

import Server.OpenServer;

import java.util.*;

public class Main {
    private static final Scanner STDIN = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter host or join.");
        String input = STDIN.nextLine();

        if (input.equals("host")) {
            Thread serverHost = new Thread(new OpenServer());
            serverHost.start();
            System.out.println("Server started.");

        } else if (input.equals("join")) {
            Client client = new Client(Server.OpenServer.IP, Server.OpenServer.DEFAULT_PORT);
        }
    }



}
