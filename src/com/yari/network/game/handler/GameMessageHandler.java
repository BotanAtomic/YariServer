package com.yari.network.game.handler;

import com.yari.network.game.Message;
import com.yari.network.game.backend.GameHandler;

public interface GameMessageHandler {

    void parse(Message message, GameHandler gameHandler);

}
