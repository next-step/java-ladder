package ladder.application;

import ladder.domain.*;
import ladder.dto.LadderGameInfo;
import ladder.dto.LadderGameResults;
import ladder.dto.LadderInfo;
import ladder.infra.RandomDirectionCreator;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderGame {
    public static Ladder createLadder(LadderInfo ladderInfo) {
        DirectionCreator directionCreator = new RandomDirectionCreator();
        return LadderCreator.create(ladderInfo, directionCreator);
    }

    public static LadderGameResults start(Ladder ladder, LadderGameInfo ladderGameInfo) {
        LadderResults ladderResults = ladder.exec();
        Users users = ladderGameInfo.getUsers();
        LadderRewards ladderRewards = ladderGameInfo.getLadderRewards();

        Map<User, LadderReward> matchResult = Stream.iterate(0, i -> i < users.size(), i -> i + 1)
                .collect(Collectors.toMap(users::getUser,
                        i -> ladderRewards.getLadderReward(ladderResults.getResultPosition(i))));
        return new LadderGameResults(matchResult);
    }
}
