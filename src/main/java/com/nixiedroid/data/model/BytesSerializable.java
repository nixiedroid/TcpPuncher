package com.nixiedroid.data.model;

import com.nixiedroid.util.ByteArrayConverter;

import java.io.IOException;

public abstract class BytesSerializable<T>{

    private final ByteArrayConverter converter;

    public BytesSerializable(ByteArrayConverter converter) {
        this.converter = converter;
    }

    protected abstract T toParcel(byte[] data) throws IOException;
    protected abstract byte[] fromParcel(T obj);
}
