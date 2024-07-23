package com.nixiedroid.data.model;

import com.nixiedroid.data.util.Endiannes;

import java.io.IOException;

public class ConnectParcel extends AbstractParcel {

    private int id;
    private short value;

    public ConnectParcel(byte[] data, int start) {
        super(data, start);
    }

    public ConnectParcel(Builder builder){
        super(builder);
        this.id = builder.id;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int marshal(byte[] data, int start) throws IOException {
        int index = super.marshal(data,start);
        converter.writeInteger(data, index, id, Endiannes.BIG);
        index += INTEGER;
        converter.writeShort(data, index, value, Endiannes.BIG);
        return index + SHORT;
    }

    @Override
    public int unmarshal(byte[] data, int start) {
        int index = super.unmarshal(data,start);
        this.id = converter.readInteger(data, index, Endiannes.BIG);
        index += INTEGER;
        this.value = converter.readShort(data, index, Endiannes.BIG);
        return index + SHORT;
    }

    public static class Builder extends AbstractParcel.Builder<Builder> {
        private int id;

        public Builder setId(int id) {
            this.id = id;
            return self();
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public ConnectParcel build() {
            return new ConnectParcel(this);
        }
    }


}
