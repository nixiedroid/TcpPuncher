package com.nixiedroid.client;

import com.nixiedroid.data.builders.ParcelFactoryImpl;
import com.nixiedroid.data.model.Parcel;
import com.nixiedroid.data.model.ParcelType;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ClientMain {

    final static InetSocketAddress address = new InetSocketAddress("localhost", 8088);


    public static void main(String[] args) {
        try (
                Socket socket = setupSocket();
                DataInputStream iStream = new DataInputStream(socket.getInputStream());
                DataOutputStream oStream = new DataOutputStream(socket.getOutputStream())
        ) {
            ParcelFactoryImpl i = new ParcelFactoryImpl();
            Parcel parcel =  i.make(ParcelType.CONNECT);
            parcel.marshal(oStream);
            System.out.println("Data sent to server.");
            int read;
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
