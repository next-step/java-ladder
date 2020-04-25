package ladder.dto;

import ladder.domain.Ladder;
import ladder.domain.LadderGameInfo;
import ladder.domain.LadderGameResults;

public class LadderResponse {
    private final Ladder ladder;
    private final LadderGameInfo ladderGameInfo;
    private final LadderGameResults ladderGameResults;

    public LadderResponse(Ladder ladder, LadderGameInfo ladderGameInfo, LadderGameResults ladderGameResults) {
        this.ladder = ladder;
        this.ladderGameInfo = ladderGameInfo;
        this.ladderGameResults = ladderGameResults;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public LadderGameInfo getLadderGameInfo() {
        return ladderGameInfo;
    }

    public LadderGameResults getLadderGameResults() {
        return ladderGameResults;
    }
}
