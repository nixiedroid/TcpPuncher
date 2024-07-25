package com.nixiedroid.binder;

import com.nixiedroid.data.model.ConnectParcel;

import java.io.*;
import java.net.Socket;

public class ClientThread implements Runnable {

    private final Socket socket;

    public ClientThread(Socket socket) throws IOException {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
                DataInputStream iStream = new DataInputStream(socket.getInputStream());
                DataOutputStream oStream = new DataOutputStream(socket.getOutputStream())
        ) {
            ConnectParcel parcel = new ConnectParcel(iStream);
            System.out.println(parcel);

           socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
