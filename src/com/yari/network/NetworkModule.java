package com.yari.network;

import com.yari.injector.AbstractModule;
import com.yari.network.game.GameServer;
import com.yari.network.http.HTTPServer;

public class NetworkModule extends AbstractModule {

    @Override
    public void configure() {
        super.bind(GameServer.class);
        super.bind(HTTPServer.class);
    }

}
