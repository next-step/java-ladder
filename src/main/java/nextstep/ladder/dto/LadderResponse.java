package nextstep.ladder.dto;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladderGame.LadderGameInfo;
import nextstep.ladder.domain.ladderGame.LadderGameResult;

import java.util.Objects;

public class LadderResponse {
    private final Ladder ladder;
    private final LadderGameInfo ladderGameInfo;
    private final LadderGameResult ladderGameResult;

    public LadderResponse(final Ladder ladder, final LadderGameInfo ladderGameInfo,
                          final LadderGameResult ladderGameResult) {
        this.ladder = Objects.requireNonNull(ladder);
        this.ladderGameInfo = Objects.requireNonNull(ladderGameInfo);
        this.ladderGameResult = Objects.requireNonNull(ladderGameResult);
    }


    public Ladder getLadder() {
        return ladder;
    }

    public LadderGameInfo getLadderGameInfo() {
        return ladderGameInfo;
    }

    public LadderGameResult getLadderGameResult() {
        return ladderGameResult;
    }
}
