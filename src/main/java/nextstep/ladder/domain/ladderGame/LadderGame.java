package nextstep.ladder.domain.ladderGame;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.LadderResult;

import java.util.Objects;

public class LadderGame {
    private final Ladder ladder;
    private final LadderGameInfo ladderGameInfo;

    public static LadderGame of(final Ladder ladder, final LadderGameInfo ladderGameInfo) {
        return new LadderGame(ladder, ladderGameInfo);
    }

    private LadderGame(final Ladder ladder, final LadderGameInfo ladderGameInfo) {
        this.ladder = Objects.requireNonNull(ladder);
        this.ladderGameInfo = Objects.requireNonNull(ladderGameInfo);
    }

    public LadderGameResult play() {
        LadderResult ladderResult = ladder.play();
        return ladderGameInfo.apply(ladderResult);
    }
}
