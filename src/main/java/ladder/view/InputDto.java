package ladder.view;

import ladder.domain.LadderResults;
import ladder.domain.Players;

public class InputDto {
    private final Players players;
    private final int height;
    private final LadderResults ladderResults;

    public InputDto(Players players, int height, LadderResults ladderResults) {
        this.players = players;
        this.height = height;
        this.ladderResults = ladderResults;
    }

    public Players getPlayers() {
        return players;
    }

    public int getHeight() {
        return height;
    }

    public LadderResults getLadderResults() {
        return ladderResults;
    }
}
