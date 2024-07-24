package com.nixiedroid.data.util.interfaces;

import com.nixiedroid.data.util.converter.Endianness;

@SuppressWarnings("unused")
public interface PrimitiveReader extends EndiannesConsumer{
    byte readByte(Endianness e);

    short readShort(Endianness e);

    int readInteger(Endianness e);

    long readLong(Endianness e);

    float readFloat(Endianness e);

    double readDouble(Endianness e);

    byte readByte();

    short readShort();

    int readInteger();

    long readLong();

    float readFloat();

    double readDouble();
}
