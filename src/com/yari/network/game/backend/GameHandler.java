package com.yari.network.game.backend;

import com.yari.network.game.Message;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class GameHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object input) throws Exception {
        Message message = (Message) input;
        System.out.println(message.getId() + "/" + message.getData().length);
    }

}
