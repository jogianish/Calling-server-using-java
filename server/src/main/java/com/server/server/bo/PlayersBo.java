package com.server.server.bo;

import java.util.List;

import com.server.server.entity.Players;

public interface PlayersBo {
    List<Players> getAllPlayers();

    Players createPlayers(Players players);

    Players updatePlayers(Players players, long id);

    void deletePlayres(long id);

}
