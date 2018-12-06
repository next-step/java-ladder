package net.chandol.ladder.v2.dto;

import net.chandol.ladder.v2.domain.player.Players;
import net.chandol.ladder.v2.domain.prize.Prizes;

public class LadderInitializeRequest {
    private Players players;
    private Prizes prizes;
    private int height;

    public LadderInitializeRequest(Players players, Prizes prizes, int height) {
        this.players = players;
        this.prizes = prizes;
        this.height = height;
    }

    public Players getPlayers() {
        return players;
    }

    public int getHeight() {
        return height;
    }

    public Prizes getPrizes() {
        return prizes;
    }
}
