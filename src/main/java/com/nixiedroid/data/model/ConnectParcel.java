package com.nixiedroid.data.model;

import com.nixiedroid.data.util.streams.PrimitiveInputStream;
import com.nixiedroid.data.util.streams.PrimitiveOutputStream;

import java.io.IOException;

public class ConnectParcel extends AbstractParcel {

    private int id;
    private short value;

    private ConnectParcel(Builder builder) {
        super(builder);
        this.id = builder.id;
        this.value = builder.value;
    }

    public ConnectParcel(AbstractParcel.Builder<?> builder) {
        super(builder);
    }

    public ConnectParcel(PrimitiveInputStream is) throws IOException {
        super(is);
    }

    @Override
    public void marshal(PrimitiveOutputStream os) throws IOException {
        super.marshal(os);
        os.writeInteger(id);
        os.writeShort(value);
    }

    @Override
    public void unmarshal(PrimitiveInputStream is) throws IOException {
        super.unmarshal(is);
        id = is.readInteger();
        value = is.readShort();
    }

    @Override
    public String toString() {
        return super.toString() + "\nConnectParcel{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }

    public static class Builder extends AbstractParcel.Builder<Builder> {
        private int id;
        private short value;

        public Builder setId(int id) {
            this.id = id;
            return self();
        }

        public Builder setValue(short value) {
            this.value = value;
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
