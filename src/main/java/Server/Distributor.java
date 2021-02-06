package Server;

import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.function.Consumer;

public class Distributor implements Runnable {
    private final List<PrintWriter> outs = new ArrayList<>();
    private final BlockingQueue<String> messageQueue = new ArrayBlockingQueue<>(10000);


    public void addNewReceiver(PrintWriter o) {
        outs.add(o);
    }

    public void removeReceiver (PrintWriter o) {
        outs.remove(o);
    }

    public void relayMessage (String message) {
        messageQueue.add(message);
    }

    public void run() {
        String message;
        while (!Thread.interrupted()) {
            try {
                System.out.println("DISTRIBUTOR: Waiting for incoming message");
                message = messageQueue.take();
                String finalMessage = message;
                System.out.println("DISTRIBUTOR: FINAL MESSAGE: " + finalMessage);
                new Thread(() -> {
                    for (PrintWriter o : outs) {
                        try {
                            o.println(finalMessage);
                            o.flush();
                        } catch (NullPointerException e)  {
                            outs.remove(o);
                        }
                    }
                }).start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



}
