package com.nixiedroid.data.util.buffer;

import com.nixiedroid.data.util.interfaces.PrimitiveReader;
import com.nixiedroid.data.util.interfaces.PrimitiveWriter;

@SuppressWarnings("unused")
public interface Buffer extends PrimitiveReader, PrimitiveWriter {

    void reallocate(int size);

    int getPointer();

    void setPointer(int pointer);

    void resetPointer();

    boolean isFull();

    void free();
}
