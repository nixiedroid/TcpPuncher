package com.nixiedroid.client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientMain {
    private static final int BYTE = 1;
  //  final static InetSocketAddress address = new InetSocketAddress("dct.nixiedroid.com", 8088);
    final static InetSocketAddress address = new InetSocketAddress("localhost", 8088);


    public static void main(String[] args) {
//
        try (
                Socket socket = setupSocket();
                BufferedInputStream iStream = new BufferedInputStream(System.in);
                BufferedOutputStream oStream = new BufferedOutputStream(socket.getOutputStream());
        ) {
            byte[] dataToSend = "Hello, ServeAvAA!".getBytes();
            oStream.write(dataToSend.length);
            oStream.write(dataToSend);
            oStream.flush();
            System.out.println("Data sent to server.");
        } catch (IOException e) {
            throw new Error(e);
        }

    }

    static Socket setupSocket() throws IOException {
        Socket so =  new Socket();
        so.setSoTimeout(500);
        so.connect(address);
        return so;
    }
}
