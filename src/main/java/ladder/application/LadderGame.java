package ladder.application;

import ladder.domain.*;
import ladder.dto.LadderGameInfo;
import ladder.dto.LadderGameResults;
import ladder.dto.LadderInfo;

import java.util.Map;

public class LadderGame {
    public static Ladder createLadder(LadderInfo ladderInfo, int height) {
        return LadderCreator.create(ladderInfo, height);
    }

    public static LadderGameResults start(Ladder ladder, LadderGameInfo ladderGameInfo) {
        LadderResults ladderResults = ladder.exec();
        Map<User, LadderReward> ladderGameResult = ladderGameInfo.match(ladderResults);
        return new LadderGameResults(ladderGameResult);
    }
}
