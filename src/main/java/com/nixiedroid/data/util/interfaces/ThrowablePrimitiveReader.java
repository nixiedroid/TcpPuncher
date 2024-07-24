package com.nixiedroid.data.util.interfaces;

import com.nixiedroid.data.util.converter.Endianness;

@SuppressWarnings("unused")
public interface ThrowablePrimitiveReader<E extends Throwable> extends EndiannesConsumer {
    byte readByte(Endianness e) throws E;

    short readShort(Endianness e) throws E;

    int readInteger(Endianness e) throws E;

    long readLong(Endianness e) throws E;

    float readFloat(Endianness e) throws E;

    double readDouble(Endianness e) throws E;

    byte readByte() throws E;

    short readShort() throws E;

    int readInteger() throws E;

    long readLong() throws E;

    float readFloat() throws E;

    double readDouble() throws E;
}
