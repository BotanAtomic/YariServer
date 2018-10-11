package com.yari.core;

import java.io.DataOutputStream;
import java.net.Socket;

public class Test {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 12345);
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());


        byte[] data = {2, 4, 3, 5, 9, 9, 9, 8, 5, 15, 26, 26, 26, 6, 26, 2, 64, 81, 52, 19, 49};

        outputStream.writeByte(125);
        outputStream.writeInt(data.length);
        outputStream.write(data);

    }

}
