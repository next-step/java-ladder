package nextstep.ladder.domain;

import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.player.Players;

public class Ladder {
    private Players players;
    private Lines lines;

    private Ladder(Players players, Lines lines) {
        this.players = players;
        this.lines = lines;
    }

    private Ladder(String[] playerNames, int ladderHeight) {
        this(new Players(playerNames), new Lines(playerNames.length, ladderHeight));
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
