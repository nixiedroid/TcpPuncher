package com.nixiedroid.data.model;

import java.io.DataInputStream;
import java.io.IOException;

public class InvalidParcel extends HeaderV1_1{
    public InvalidParcel() {
        super(ParcelType.INVALID);
    }

    public InvalidParcel(DataInputStream is) throws IOException {
        super(is);
    }
}
