package com.nixiedroid.binder;

import com.nixiedroid.data.model.ConnectParcel;
import com.nixiedroid.data.util.streams.PrimitiveInputStream;
import com.nixiedroid.data.util.streams.PrimitiveOutputStream;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientThread implements Runnable {

    private final Socket socket;

    public ClientThread(Socket socket) throws IOException {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
                PrimitiveInputStream iStream = new PrimitiveInputStream(socket.getInputStream());
                PrimitiveOutputStream oStream = new PrimitiveOutputStream(socket.getOutputStream())
        ) {
            ConnectParcel parcel = new ConnectParcel(iStream);
            System.out.println(parcel);

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
