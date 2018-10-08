package com.yari.network.game;

import com.yari.api.Service;
import com.yari.injector.api.InjectConfiguration;
import com.yari.network.api.NetworkService;


@NetworkService
public class GameServer implements Service {

    @InjectConfiguration("network-port")
    private int port;

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

}
