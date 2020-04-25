package ladder.application;

import ladder.domain.Ladder;
import ladder.domain.LadderGameInfo;
import ladder.domain.LadderGameResults;

import java.util.Objects;

public class LadderGame {
    private final Ladder ladder;
    private final LadderGameInfo ladderGameInfo;

    public LadderGame(final Ladder ladder, final LadderGameInfo ladderGameInfo) {
        this.ladder = Objects.requireNonNull(ladder);
        this.ladderGameInfo = Objects.requireNonNull(ladderGameInfo);
    }

    public LadderGameResults start() {
        return new LadderGameResults(ladderGameInfo.match(ladder.exec(ladderGameInfo.userSize())));
    }
}
