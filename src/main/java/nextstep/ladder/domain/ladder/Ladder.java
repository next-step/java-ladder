package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.player.Count;

public class Ladder {
    private final Rows rows;

    public Ladder(Height height, Count playerCount, RungGenerateStrategy strategy) {
        this(new Rows(height, playerCount, strategy));
    }

    public Ladder(Rows rows) {
        this.rows = rows;
    }
}
