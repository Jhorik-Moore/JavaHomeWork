package com.gvozdev.serverchat;

import javafx.scene.layout.VBox;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;


    public Server(ServerSocket serverSocket) {
        try {
            this.serverSocket = serverSocket;
            this.socket = serverSocket.accept();
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (Exception e){
            e.getStackTrace();
            System.out.println("Error creating Server..");
            closeBufferSocket(socket,bufferedReader,bufferedWriter);
        }
    }

    public void sendMessageToClient(String toClient) {
        try {
            bufferedWriter.write(toClient);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("Error sending message to Client");
            closeBufferSocket(socket, bufferedReader, bufferedWriter);
        }
    }

    public void fromClientMessage(VBox vBox) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (socket.isConnected()) {
                    try {
                        String messageFromClient = bufferedReader.readLine();
                        ChatController.addLabel(messageFromClient,vBox);
                    } catch (IOException e) {
                        e.printStackTrace();
                        closeBufferSocket(socket, bufferedReader, bufferedWriter);
                        break;
                    }
                }
            }
        }).start();
    }

    public void closeBufferSocket(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        try {
            if (socket != null)
                socket.close();
            if (bufferedReader != null)
                bufferedReader.close();
            if (bufferedWriter != null)
                bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
