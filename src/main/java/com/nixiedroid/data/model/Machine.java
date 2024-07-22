package com.nixiedroid.data.model;

public enum Machine {
    CLIENT(0x01), SERVER(0x02);
    private final int i;

    Machine(int i) {
        this.i = i;
    }

    public int getType() {
        return i;
    }
    public String getName(){
        return name();
    }
}
