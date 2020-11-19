package step2.domain.ladder.dto;

import step2.domain.ladder.LadderPlayers;

import java.util.Objects;

public class LadderBuildDTO {
    public static final String ERROR_INVALID_LADDER_HEIGHT = "사다리 높이는 0보다 커야 합니다.";
    private final LadderPlayers players;
    private final int lineHeight;

    public LadderBuildDTO(LadderPlayers players, int lineHeight) {
        isValidElements(players, lineHeight);

        this.players = players;
        this.lineHeight = lineHeight;
    }

    private void isValidElements(LadderPlayers players, int lineHeight) {
        isValidPlayer(players);
        isValidLineHeight(lineHeight);
    }

    private void isValidPlayer(LadderPlayers players) {
        Objects.requireNonNull(players);
    }

    private void isValidLineHeight(int lineHeight) {
        if (lineHeight <= 0) {
            throw new IllegalArgumentException(ERROR_INVALID_LADDER_HEIGHT);
        }
    }

    public LadderPlayers getPlayers() {
        return players;
    }

    public int getLineHeight() {
        return lineHeight;
    }
}
