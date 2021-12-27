package com.pb.gvozdev.hw14;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiServer {
    static class Transfer implements Runnable {
        private final Socket socket;

        public Transfer(Socket socket) {
            this.socket = socket;
        }

        @SneakyThrows
        @Override
        public void run() {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            System.out.println("->> Waiting for messages...");
            String clientMessage;
            while ((clientMessage = input.readLine()) != null) {
                if (clientMessage.equals("stop")) {
                    break;
                }
                output.println(clientMessage);
                Date date = new Date();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println(Thread.currentThread().getName()
                        + ":\n Client Request at " + format.format(date) + " -> " + clientMessage);
            }

            output.close();
            input.close();
            socket.close();
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 6643;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("-> Server start on port : " + port);
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("-> Client " +
                    clientSocket.getLocalSocketAddress() + " connected!");

            threadPool.submit(new Transfer(clientSocket));
        }
    }
}
