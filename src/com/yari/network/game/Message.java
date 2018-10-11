package com.yari.network.game;

public class Message {

    private short id;

    private byte[] data;

    public Message(short id, byte[] data) {
        this.id = id;
        this.data = data;
    }

    public short getId() {
        return id;
    }

    public byte[] getData() {
        return data;
    }
}
