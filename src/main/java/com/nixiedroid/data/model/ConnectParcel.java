package com.nixiedroid.data.model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ConnectParcel extends HeaderV1_1 {

    private int id;
    private short value;

    public ConnectParcel(int id, short value) {
        super(ParcelType.CONNECT);
        this.id = id;
        this.value = value;
    }

    public ConnectParcel(DataInputStream is) throws IOException {
        super(is);
    }

    @Override
    public void marshal(DataOutputStream os) throws IOException {
        super.marshal(os);
        os.writeInt(id);
        os.writeShort(value);
    }

    @Override
    public void unmarshal(DataInputStream is) throws IOException {
        super.unmarshal(is);
        id = is.readInt();
        value = is.readShort();
    }

    @Override
    public String toString() {
        return super.toString() + "id=" + id + ", value=" + value;
    }

}
