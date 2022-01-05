package com.gvozdev.clientchat;

import javafx.scene.layout.VBox;

import java.io.*;
import java.net.Socket;

public class Client {
 private Socket socket;
 private BufferedReader bufferedReader;
 private BufferedWriter bufferedWriter;

    public Client(Socket socket) {
        try{
            this.socket = socket;
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Error creating Client...");
            closeBufferSocket(socket, bufferedReader, bufferedWriter);
        }
    }

    public void sendMessageToServer(String messageToServer){
        try {
            bufferedWriter.write(messageToServer);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("Error sending message to Server");
            closeBufferSocket(socket, bufferedReader, bufferedWriter);
        }
    }

    public void fromServerMessage(VBox vBox){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (socket.isConnected()) {
                    try {
                        String messageFromClient = bufferedReader.readLine();
                        ClientController.addLabel(messageFromClient,vBox);
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
