package com.yari.core;

import com.yari.files.FilesUtils;
import com.yari.injector.Injector;
import com.yari.network.NetworkModule;
import com.yari.network.game.GameServer;
import org.json.JSONObject;

public class Main {

    public static void main(String[] args) {
        Header.show();

        Injector injector = Injector.create();
        injector.bindConfiguration(new JSONObject(FilesUtils.readAll("configuration.json")));

        injector.bind(new NetworkModule());

        GameServer gameServer = injector.get(GameServer.class);
    }
}
