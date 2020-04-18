package ladder.dto;

import ladder.domain.*;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderGameInfo {
    private final Users users;
    private final LadderRewards ladderRewards;

    public LadderGameInfo(Users users, LadderRewards ladderRewards) {
        this.users = users;
        this.ladderRewards = ladderRewards;
    }

    public Map<User, LadderReward> match(LadderResults ladderResults) {
        return Stream.iterate(0, i -> i < users.size(), i -> i + 1)
                .collect(Collectors.toMap(users::getUser,
                        i -> ladderRewards.getLadderReward(ladderResults.getResultPosition(i))));

    }
}
