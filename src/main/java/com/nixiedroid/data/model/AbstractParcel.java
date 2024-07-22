package com.nixiedroid.data.model;

import com.nixiedroid.data.model.header.Header;
import com.nixiedroid.util.ByteArrayConverter;

public abstract class AbstractParcel extends BytesSerializable<AbstractParcel> {

    private Header header;

    public AbstractParcel(ByteArrayConverter converter) {
        super(converter);
    }

    public int getSize() {
        return size();
    }

    abstract int size();

}
