package nextstep.ladder.domain;

import nextstep.ladder.domain.line.Height;
import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.line.strategy.LineCreateStrategy;
import nextstep.ladder.domain.user.LadderUsers;

public class Ladder {
    private final LadderUsers ladderUsers;
    private final Lines lines;

    public Ladder(String names, int height, LineCreateStrategy lineCreateStrategy) {
        this.ladderUsers = new LadderUsers(names);
        this.lines = new Lines(this.ladderUsers, new Height(height), lineCreateStrategy);
    }

    @Override
    public String toString() {
        return ladderUsers + "\n" + lines;
    }
}
