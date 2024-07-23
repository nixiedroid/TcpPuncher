package com.nixiedroid.data.interfaces;

import java.io.IOException;

public interface Marshallable {

    int BYTE = 1;
    int SHORT = 2;
    int INTEGER = 4;
    int LONG = 8;

    int marshal(byte[] data, int start) throws IOException;

    int unmarshal(byte[] data, int start) throws IOException;

    int size();

    default void throwIOException(String mesage) throws IOException {
        throw new IOException(mesage);
    }
}
