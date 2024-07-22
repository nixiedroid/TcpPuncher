package com.nixiedroid.data.model.header;

import com.nixiedroid.data.model.BytesSerializable;

import java.io.IOException;

public class Header extends BytesSerializable<Header> {
    public static final int SIZE = 4;
    private final short messageLen;
    private final Type messageType;

    public Header(short messageLen, Type messageType) {
        this.messageLen = messageLen;
        this.messageType = messageType;
    }

    public short getMessageLen() {
        return messageLen;
    }

    public Type getMessageType() {
        return messageType;
    }

    @Override
    protected Header toParcel(byte[] data) throws IOException {
        return null;
    }

    @Override
    protected byte[] fromParcel(Header obj) {
        return new byte[0];
    }
}
