package com.nixiedroid.binder;

import java.io.*;
import java.net.Socket;

public class ClientThread implements Runnable {

    private final Socket socket;

    public ClientThread(Socket socket) throws IOException {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedInputStream iStream = new BufferedInputStream(socket.getInputStream());
             BufferedOutputStream oStream = new BufferedOutputStream(System.out)) {

            int ch;
            Reader r = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while ((ch =  r.read())!=-1){
                System.out.print((char) ch);
            }

//            int length = iStream.read();
//            byte[] dataReceived = readFully(length, iStream);
//            String message = new String(dataReceived);
//            System.out.println("Received message: " + message);
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public final byte[] readFully(int length, InputStream in) throws IOException {
        byte[] b = new byte[length];
        int n = 0;
        while (n < length) {
            int count = in.read(b, n, length - n);
            if (count < 0)
                throw new EOFException();
            n += count;
        }
        return b;
    }
}
