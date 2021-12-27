package com.pb.gvozdev.hw14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
    public static void main(String[] args) throws Exception {
        System.out.println("-> Client is started...");

        String serverIp = "localhost";
        int serverPort = 6643;
        System.out.println("-> Server connect ... " + serverIp + ":" + serverPort);

        Socket server = new Socket(serverIp, serverPort);
        BufferedReader inServer = new BufferedReader(new InputStreamReader(server.getInputStream()));
        PrintWriter outServer = new PrintWriter(server.getOutputStream(), true);
        BufferedReader inConsole = new BufferedReader(new InputStreamReader(System.in));

        String userInput, serverAnswer;

        while ((userInput = inConsole.readLine()) != null) {
            outServer.println(userInput);
            serverAnswer = inServer.readLine();
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println("Server Response at " + format.format(date) + " -> " + serverAnswer);
            if (userInput.equals("stop")) {
                break;
            }
        }
        outServer.close();
        inServer.close();
        server.close();
    }
}
