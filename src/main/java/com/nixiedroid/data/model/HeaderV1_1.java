package com.nixiedroid.data.model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public abstract class HeaderV1_1 extends Parcel {
    private short verMajor = 1;
    private short verMinor = 1;
    private short messageLen = 0;
    private ParcelType parcelType;

    public HeaderV1_1(ParcelType type) {
        parcelType = type;
    }

    public HeaderV1_1(DataInputStream is) throws IOException {
        super(is);
    }

    @Override
    public String toString() {
        return super.toString() + "V " + verMajor + "." + verMinor + parcelType.toString();
    }

    @Override
    public void marshal(DataOutputStream os) throws IOException {
        super.marshal(os);
        os.writeShort(verMajor);
        os.writeShort(verMinor);
        os.writeShort(messageLen);
        os.writeShort(parcelType.ordinal());
    }

    @Override
    public void unmarshal(DataInputStream is) throws IOException {
        super.unmarshal(is);
        verMajor = is.readShort();
        verMinor = is.readShort();
        messageLen = is.readShort();
        parcelType =  ParcelType.values()[is.readShort()];
    }
}
