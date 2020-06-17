package nextstep.ladder.domain;

import java.util.List;

public class Ladder {

    private Players players;
    private Lines lines;

    private Ladder(List<String> userNames, int ladderHeight) {
        this.players = Players.of(userNames);
        this.lines = Lines.of(userNames.size(), ladderHeight);
    }

    public static Ladder of(List<String> userNames, Integer ladderHeight) {
        return new Ladder(userNames, ladderHeight);
    }

    public Players getPlayers() {
        return this.players;
    }

    public Lines getLines() {
        return this.lines;
    }
}
