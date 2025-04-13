package nextstep.ladder.domain;

import nextstep.ladder.domain.edge.LadderPrizes;
import nextstep.ladder.domain.edge.LadderUsers;
import nextstep.ladder.domain.line.Height;
import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.line.LineFactory;
import nextstep.ladder.domain.line.Lines;

public class Ladder {
    private final Lines lines;
    private final LadderUsers users;
    private final LadderPrizes prizes;

    public Ladder(LadderUsers users, LadderPrizes prizes, int height) {
        this(users, prizes, new Height(height), new LineFactory());
    }

    public Ladder(LadderUsers users, LadderPrizes prizes, Height height, LineFactory lineFactory) {
        this.users = users;
        this.prizes = prizes;
        this.lines = new Lines(users.size(), height, lineFactory);
    }
}
