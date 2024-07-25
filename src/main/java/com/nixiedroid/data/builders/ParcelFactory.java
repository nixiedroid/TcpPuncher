package com.nixiedroid.data.builders;

import com.nixiedroid.data.model.Parcel;
import com.nixiedroid.data.model.ParcelType;

import java.io.DataInputStream;
import java.io.IOException;

public interface ParcelFactory {

    Parcel make(ParcelType type);

    Parcel unmarshall(DataInputStream is) throws IOException;
}
