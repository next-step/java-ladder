package net.chandol.ladder.v2.dto;

import net.chandol.ladder.v2.domain.Players;

public class LadderGameInitializeRequest {
    private Players players;
    private int height;

    public LadderGameInitializeRequest(Players players, int height) {
        this.players = players;
        this.height = height;
    }

    public Players getPlayers() {
        return players;
    }

    public int getHeight() {
        return height;
    }
}
