package com.nixiedroid.client;

import com.nixiedroid.data.model.ConnectParcel;
import com.nixiedroid.data.model.Type;
import com.nixiedroid.data.util.streams.PrimitiveInputStream;
import com.nixiedroid.data.util.streams.PrimitiveOutputStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ClientMain {
    private static final int BYTE = 1;

    final static InetSocketAddress address = new InetSocketAddress("localhost", 8088);


    public static void main(String[] args) {
        try (
                Socket socket = setupSocket();
                PrimitiveInputStream iStream = new PrimitiveInputStream(socket.getInputStream());
                PrimitiveOutputStream oStream = new PrimitiveOutputStream(socket.getOutputStream())
        ) {
            ConnectParcel parcel = new ConnectParcel.Builder()
                    .setId(5)
                    .setValue((short) 0xFFFF)
                    .setVerMinor((short) 99)
                    .setMessageLen((short) 2)
                    .setMessageType(Type.CONNECT_ACK)
                    .setVerMajor((short) 3).build();
            parcel.marshal(oStream);
            System.out.println("Data sent to server.");
            int read=0;
            while ((read = iStream.read())!=-1){
                System.out.println(read);
            }
        } catch (SocketTimeoutException ignored) {

        } catch (IOException e){
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
