package Host;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Receiver implements Runnable {

    private final Socket serverSocket;
    private Scanner clientReceive; //Stuff from client
    private PrintWriter serverOut; //Stuff sent to client

    //Going to retrieve all comms from clients and put in to data base

    public Receiver (Socket serverSocket) throws IOException  {
        System.out.println("Receiver started");
        this.serverSocket = serverSocket;
        clientReceive = new Scanner(serverSocket.getInputStream());
        serverOut = new PrintWriter(serverSocket.getOutputStream());

    }

    //Continuously print stream to server
    public void run() {
        while (true) {
            if (clientReceive.hasNext()) {
                System.out.println(clientReceive.next());
            }
        }
    }
}
