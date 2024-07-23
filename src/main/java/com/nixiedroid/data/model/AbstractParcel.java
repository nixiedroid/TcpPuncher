package com.nixiedroid.data.model;

import com.nixiedroid.data.interfaces.Marshallable;
import com.nixiedroid.data.util.ByteArrayConverter;
import com.nixiedroid.data.util.ByteArrayConverterDefault;
import com.nixiedroid.data.util.Endiannes;

import java.io.IOException;


public abstract class AbstractParcel implements Marshallable {

    public static final int SIZE = 4;
    protected int pointer = 0;
    private static final short MAGIC = (short) 0xB10B;
    protected final ByteArrayConverter converter = new ByteArrayConverterDefault();
    private short verMajor = 0;
    private short verMinor = 0;
    private short messageLen = 0;
    private Type messageType = Type.INVALID;


    public AbstractParcel(Builder<?> builder) {
        this.verMajor = builder.verMajor;
        this.verMinor = builder.verMinor;
        this.messageLen = builder.messageLen;
        this.messageType = builder.messageType;
    }

    public AbstractParcel(byte[] data, int start) {
        unmarshal(data, start);
    }

    private AbstractParcel() {}

    private boolean isMagicValid(short magic) {
        return magic == MAGIC;
    }

    @Override
    public int marshal(byte[] data, int start) throws IOException {
        int idx = 0;
        if (!isMagicValid(converter.readShort(data, start, Endiannes.BIG))) {
            throwIOException("Invalid magic");
        }
        idx += SHORT;


        return idx;
    }

    @Override
    public int unmarshal(byte[] data, int start) {
        int index = start;
        this.verMajor = converter.readShort(data, index, Endiannes.BIG);
        index += SHORT;
        this.verMinor = converter.readShort(data, index, Endiannes.BIG);
        index += SHORT;
        this.messageLen = converter.readShort(data, index, Endiannes.BIG);
        index += SHORT;
        this.messageType = Type.values()[converter.readShort(data, index, Endiannes.BIG)];
        return index + SHORT;
    }

    public short getVerMajor() {
        return verMajor;
    }

    public short getVerMinor() {
        return verMinor;
    }

    public short getMessageLen() {
        return messageLen;
    }

    public Type getMessageType() {
        return messageType;
    }

    public abstract static class Builder<T extends Builder<T>> {

        private short verMajor = 0;
        private short verMinor = 0;
        private short messageLen = 0;
        private Type messageType = Type.INVALID;

        protected abstract T self();

        public abstract AbstractParcel build();

        public void setVerMajor(short verMajor) {
            this.verMajor = verMajor;
        }

        public void setVerMinor(short verMinor) {
            this.verMinor = verMinor;
        }

        public void setMessageLen(short messageLen) {
            this.messageLen = messageLen;
        }

        public void setMessageType(Type messageType) {
            this.messageType = messageType;
        }

    }
}
