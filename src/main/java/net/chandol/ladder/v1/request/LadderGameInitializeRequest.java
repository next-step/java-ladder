package net.chandol.ladder.v1.request;

import net.chandol.ladder.v1.domain.player.Players;
import net.chandol.ladder.v1.value.Positive;

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
