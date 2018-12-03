package net.chandol.ladder.v2.dto;

import java.util.List;

public class LadderGameInitializeRequest {
    private List<String> players;
    private int height;

    public LadderGameInitializeRequest(List<String> players, int height) {
        this.players = players;
        this.height = height;
    }

    public List<String> getPlayers() {
        return players;
    }

    public int getHeight() {
        return height;
    }
}
