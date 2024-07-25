package com.nixiedroid.data.builders;

import com.nixiedroid.data.model.*;

import java.io.DataInputStream;
import java.io.IOException;

public class ParcelFactoryImpl implements ParcelFactory{
    @Override
    public Parcel make(ParcelType type) {
        Parcel p;
        switch (type){
            case CONNECT:
                p = new ConnectParcel(1, (short) 2);
                break;
            case NACK:
            case CONNECT_ACK:
            default:
                p = new InvalidParcel();
                break;
        }
        return p;
    }

    @Override
    public Parcel unmarshall(DataInputStream is) throws IOException {
        Parcel p = new HeaderV1_1(is);

        return null;
    }
}
