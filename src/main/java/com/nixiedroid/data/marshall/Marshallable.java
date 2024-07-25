package com.nixiedroid.data.marshall;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public interface Marshallable {

    void marshal(DataOutputStream os) throws IOException;

    void unmarshal(DataInputStream is) throws IOException;

    default void throwIOException(String mesage) throws IOException {
        throw new IOException(mesage);
    }
}
