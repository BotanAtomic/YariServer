package com.yari.network.game.backend;

import com.yari.network.game.Message;
import com.yari.network.game.handler.GameMessageHandler;
import com.yari.network.game.handler.LoginHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class GameHandler extends ChannelInboundHandlerAdapter {

    private GameMessageHandler messageHandler = new LoginHandler();

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Channel [" + ctx.channel().id().asShortText() + "] : connected");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object input) throws Exception {
        messageHandler.parse((Message) input, this);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Channel [" + ctx.channel().id().asShortText() + "] : disconnected");
    }

}
