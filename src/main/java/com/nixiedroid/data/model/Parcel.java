package com.nixiedroid.data.model;

import com.nixiedroid.data.marshall.Marshallable;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


public abstract class Parcel implements Marshallable {

    private static final short MAGIC = (short) 0xC0DE;

    public Parcel() {

    }

    public Parcel(DataInputStream is) throws IOException {
        unmarshal(is);
    }


    private boolean isMagicValid(short magic) {
        return magic == MAGIC;
    }


    @Override
    public String toString() {
        return "Parcel";
    }

    @Override
    public void marshal(DataOutputStream os) throws IOException {
        os.writeShort(MAGIC);
    }

    @Override
    public void unmarshal(DataInputStream is) throws IOException {
        if (!isMagicValid(is.readShort())) {
            throwIOException("Invalid magic");
        }
    }
}
