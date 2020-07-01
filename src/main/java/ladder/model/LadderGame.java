package ladder.model;

import ladder.model.dto.LadderGameInfo;
import ladder.view.LadderGameResult;

public class LadderGame {

    private final LadderGameInfo ladderGameInfo;
    private final Ladder ladder;

    private LadderGame(final LadderGameInfo ladderGameInfo, final Ladder ladder) {
        this.ladderGameInfo = ladderGameInfo;
        this.ladder = ladder;
    }

    public static LadderGame create(final LadderGameInfo ladderGameInfo, final Ladder ladder) {
        return new LadderGame(ladderGameInfo, ladder);
    }

    public LadderGameInfo getLadderGameInfo() {
        return ladderGameInfo;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public LadderGameResult start() {
        return ladderGameInfo.makeGameResult(ladder.proceedAll());
    }
}
