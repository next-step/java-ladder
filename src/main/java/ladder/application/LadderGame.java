package ladder.application;

import ladder.domain.*;
import ladder.dto.LadderGameInfo;
import ladder.dto.LadderGameResults;
import ladder.dto.LadderInfo;
import ladder.infra.RandomDirectionCreator;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    public static Ladder createLadder(LadderInfo ladderInfo) {
        DirectionCreator directionCreator = new RandomDirectionCreator();
        return LadderCreator.create(ladderInfo, directionCreator);
    }

    public static LadderGameResults start(Ladder ladder, LadderGameInfo ladderGameInfo) {
        LadderResults ladderResults = ladder.exec();
        Users users = ladderGameInfo.getUsers();
        LadderRewards ladderRewards = ladderGameInfo.getLadderRewards();

        int userCount = users.size();
        Map<User, LadderReward> matchResult = IntStream.range(0, userCount)
                .boxed()
                .collect(Collectors.toMap(users::getUser,
                        index -> ladderRewards.getLadderReward(ladderResults.getResultPosition(index))));
        return new LadderGameResults(matchResult);
    }
}
