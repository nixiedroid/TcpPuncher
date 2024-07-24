package com.nixiedroid.data.model;

import com.nixiedroid.data.marshall.Marshallable;
import com.nixiedroid.data.util.converter.Endianness;
import com.nixiedroid.data.util.streams.PrimitiveInputStream;
import com.nixiedroid.data.util.streams.PrimitiveOutputStream;

import java.io.IOException;


public abstract class AbstractParcel implements Marshallable {

    private static final short MAGIC = (short) 0xB10B;
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

    public AbstractParcel(PrimitiveInputStream is) throws IOException {
        unmarshal(is);
    }

    private AbstractParcel() {}

    private boolean isMagicValid(short magic) {
        return magic == MAGIC;
    }


    @Override
    public String toString() {
        return "AbstractParcel{" +
                "verMajor=" + verMajor +
                ", verMinor=" + verMinor +
                ", messageLen=" + messageLen +
                ", messageType=" + messageType +
                '}';
    }

    @Override
    public void marshal(PrimitiveOutputStream os) throws IOException {
        os.writeShort(MAGIC,Endianness.BIG_ENDIAN);
        os.writeShort(verMajor,Endianness.BIG_ENDIAN);
        os.writeShort(verMinor,Endianness.BIG_ENDIAN);
        os.writeShort(messageLen,Endianness.BIG_ENDIAN);
        os.writeShort((short) messageType.ordinal(),Endianness.BIG_ENDIAN);
    }

    @Override
    public void unmarshal(PrimitiveInputStream is) throws IOException {
        if (!isMagicValid(is.readShort(Endianness.BIG_ENDIAN))) {
            throwIOException("Invalid magic");
        }
        this.verMajor = is.readShort(Endianness.BIG_ENDIAN);
        this.verMinor = is.readShort( Endianness.BIG_ENDIAN);
        this.messageLen = is.readShort(Endianness.BIG_ENDIAN);
        this.messageType = Type.values()[is.readShort(Endianness.BIG_ENDIAN)];
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

        public T setVerMajor(short verMajor) {
            this.verMajor = verMajor;
            return self();
        }

        public T setVerMinor(short verMinor) {
            this.verMinor = verMinor;
            return self();
        }

        public T setMessageLen(short messageLen) {
            this.messageLen = messageLen;
            return self();
        }

        public T setMessageType(Type messageType) {
            this.messageType = messageType;
            return self();
        }

    }
}
