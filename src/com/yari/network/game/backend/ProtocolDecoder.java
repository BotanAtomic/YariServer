package com.yari.network.game.backend;

import com.yari.network.game.Message;
import com.yari.network.game.Protocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class ProtocolDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() < (Protocol.MESSAGE_ID_SIZE + Protocol.SIZE_HEADER)) {
            in.resetReaderIndex();
        } else {
            short id = in.readByte();
            int size = in.readInt();
            byte[] data = new byte[size];
            in.readBytes(data);

            out.add(new Message(id, data));
        }
    }

}
