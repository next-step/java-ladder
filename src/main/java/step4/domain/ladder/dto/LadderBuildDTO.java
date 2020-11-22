package step4.domain.ladder.dto;

import step4.domain.ladder.LadderPlayers;

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
