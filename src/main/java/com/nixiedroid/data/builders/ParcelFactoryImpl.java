package com.nixiedroid.data.builders;

import com.nixiedroid.data.model.ConnectParcel;
import com.nixiedroid.data.model.InvalidParcel;
import com.nixiedroid.data.model.Parcel;
import com.nixiedroid.data.model.ParcelType;

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
}
