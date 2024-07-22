package com.nixiedroid.data.model;

import java.io.IOException;

public class ConnectParcel extends AbstractParcel{
    @Override
    int size() {
        return 0;
    }

    @Override
    protected AbstractParcel toParcel(byte[] data) throws IOException {
        return null;
    }

    @Override
    protected byte[] fromParcel(AbstractParcel obj) {
        return new byte[0];
    }
}
