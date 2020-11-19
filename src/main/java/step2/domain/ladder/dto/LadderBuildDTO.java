package step2.domain.ladder.dto;

import step2.domain.ladder.LadderPlayers;

import java.util.Objects;

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
