package com.yari.network.game.handler;

import com.yari.network.game.Message;
import com.yari.network.game.api.MessageIdentity;
import com.yari.network.game.backend.GameHandler;

@MessageIdentity(0)
public class LoginHandler implements GameMessageHandler {

    @Override
    public void parse(Message message, GameHandler gameHandler) {

    }


}
