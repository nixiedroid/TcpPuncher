package com.nixiedroid.data.marshall;

import com.nixiedroid.data.util.streams.PrimitiveInputStream;
import com.nixiedroid.data.util.streams.PrimitiveOutputStream;

import java.io.IOException;

public interface Marshallable {

    void marshal(PrimitiveOutputStream os) throws IOException;

    void unmarshal(PrimitiveInputStream is) throws IOException;

    default void throwIOException(String mesage) throws IOException {
        throw new IOException(mesage);
    }
}
