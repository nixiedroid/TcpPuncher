package com.nixiedroid.data;

import com.nixiedroid.data.model.Parcel;

public class ParcelService {
    public  byte[] serialize(Parcel p){
        return new byte[Parcel.SIZE];
    }

    public Parcel deserialize(byte[] bytes){
        return new Parcel(null,3);
    }
}
