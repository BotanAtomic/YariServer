package com.yari.network.game;

import com.yari.api.Service;
import com.yari.injector.api.InjectConfiguration;
import com.yari.network.api.NetworkService;
import com.yari.network.game.backend.GameHandler;
import com.yari.network.game.backend.ProtocolDecoder;
import com.yari.utils.ExceptionManager;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;


@NetworkService
public class GameServer implements Service {

    @InjectConfiguration("network-port")
    private int port;

    @Override
    public void start() {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<>() {
                        @Override
                        protected void initChannel(Channel channel) throws Exception {
                            channel.pipeline().addLast(new ProtocolDecoder(),new GameHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childOption(ChannelOption.TCP_NODELAY, true);

            ChannelFuture f = b.bind(port).sync();

            System.out.println("Game server successfully started on port " + port);

            f.channel().closeFuture().sync();
        } catch (Exception e) {
            ExceptionManager.register(e);
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    @Override
    public void stop() {

    }

}
