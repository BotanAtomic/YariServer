package com.yari.network.game.backend;

import com.yari.network.game.Message;
import com.yari.network.game.Protocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class ProtocolDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
        if (in.readableBytes() < Protocol.TOTAL_HEADER_SIZE) {
            in.resetReaderIndex();
        } else {
            byte id = in.readByte();
            int size = in.readInt();
            byte[] data = new byte[size];
            in.readBytes(data);

            out.add(new Message(id, data));
        }
    }

}
