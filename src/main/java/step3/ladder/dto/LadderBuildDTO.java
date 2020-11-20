package step3.ladder.dto;

import step3.ladder.LadderPlayers;

public class LadderBuildDTO {

    private final LadderPlayers players;
    private final int lineHeight;

    public LadderBuildDTO(LadderPlayers players, int lineHeight) {
        this.players = players;
        this.lineHeight = lineHeight;
    }

    public LadderPlayers getPlayers() {
        return players;
    }

    public int getLineHeight() {
        return lineHeight;
    }
}
