package Client;

import Server.Start;

import java.util.*;

public class Main {
    private static final Scanner STDIN = new Scanner(System.in);

    public static void main(String[] args) {

        String ip = STDIN.nextLine();

        Client client = new Client(ip, Start.DEFAULT_PORT);
    }
}
