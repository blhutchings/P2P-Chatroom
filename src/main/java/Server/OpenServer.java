package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class OpenServer implements Runnable{

    public static int DEFAULT_PORT = 4214;
    public  static final String IP = "localhost";

    private ServerSocket serverSocket;
    private final List<Thread> threadList = new LinkedList<>();



    //Allows continuos connections
    public void run() {
        try {
            serverSocket = new ServerSocket(DEFAULT_PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (!Thread.interrupted()) {
            try {
                Socket newConnection = serverSocket.accept();
                System.out.println("Connection made");
                Thread thread = new Thread(new Receiver(newConnection)); //Make new thread to handle text input from client
                thread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Openserver ended");
    }
}
