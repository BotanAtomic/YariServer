package com.yari.network.game;

/**
 * Size in byte of each part of message protocol
 */
public class Protocol {

    public final static int MESSAGE_ID_SIZE = 1;

    public final static int SIZE_HEADER = 4;

    public final static int TOTAL_HEADER_SIZE = MESSAGE_ID_SIZE + SIZE_HEADER;

}
