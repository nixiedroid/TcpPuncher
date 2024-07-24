package com.nixiedroid.binder;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BinderMain {

    public static void main(String[] args) {
        serverLoop();
    }

    public static void serverLoop() {
        int port = 8088;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            //   serverSocket.setSoTimeout(500);
            System.out.println(serverSocket);
            while (true){
                Socket clientSocket = serverSocket.accept();
              //  clientSocket.setKeepAlive(true);
                clientSocket.setSoTimeout(3500);
                System.out.println(clientSocket);
                new Thread(new ClientThread(clientSocket)).start();
                System.out.println("Thread Created");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
