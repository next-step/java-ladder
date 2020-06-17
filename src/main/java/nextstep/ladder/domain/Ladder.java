package nextstep.ladder.domain;

import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.strategy.RandomStrategy;

public class Ladder {
    private final Players players;
    private final Lines lines;

    private Ladder(Players players, Lines lines) {
        this.players = players;
        this.lines = lines;
    }

    private Ladder(String[] playerNames, int ladderHeight) {
        this(new Players(playerNames), new Lines(new RandomStrategy(), playerNames.length, ladderHeight));
    }

    public static Ladder of(String[] playerNames, int ladderHeight) {
        return new Ladder(playerNames, ladderHeight);
    }

    public Players getPlayers() {
        return players;
    }

    public Lines getLines() {
        return lines;
    }
}
