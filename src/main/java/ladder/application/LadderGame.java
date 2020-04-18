package ladder.application;

import ladder.domain.*;
import ladder.dto.LadderGameInfo;
import ladder.dto.LadderGameResults;
import ladder.dto.LadderInfo;
import ladder.infra.RandomDirectionCreator;

import java.util.Map;

public class LadderGame {
    public static Ladder createLadder(LadderInfo ladderInfo) {
        DirectionCreator directionCreator = new RandomDirectionCreator();
        return LadderCreator.create(ladderInfo, directionCreator);
    }

    public static LadderGameResults start(Ladder ladder, LadderGameInfo ladderGameInfo) {
        LadderResults ladderResults = ladder.exec();
        Map<User, LadderReward> ladderGameResult = ladderGameInfo.match(ladderResults);
        return new LadderGameResults(ladderGameResult);
    }
}
