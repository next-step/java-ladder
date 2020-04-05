package Ladder.domain;

import java.util.stream.IntStream;

public class LadderGame {
    private final Ladder ladder;
    private final Players players;

    private LadderGame(final Players players, final Ladder ladder) {
        this.ladder = ladder;
        this.players = players;
    }

    public static LadderGame of (final String[] playerNameArr, final Ladder ladder) {
        return new LadderGame(new Players(playerNameArr), ladder);
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Players getPlayers() {
        return players;
    }
}
