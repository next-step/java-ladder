package net.chandol.request;

import net.chandol.domain.player.Players;
import net.chandol.value.Positive;

public class LadderGameInitializeRequest {
    private Players players;
    private Positive height;

    public LadderGameInitializeRequest(Players players, Positive height) {
        this.players = players;
        this.height = height;
    }

    public Players getPlayers() {
        return players;
    }

    public Positive getHeight() {
        return height;
    }
}
