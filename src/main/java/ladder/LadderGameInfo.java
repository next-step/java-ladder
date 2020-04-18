package ladder;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderGameInfo {
    private final Users users;
    private final LadderRewards ladderRewards;

    public LadderGameInfo(Users users, LadderRewards ladderRewards) {
        this.users = users;
        this.ladderRewards = ladderRewards;
    }

    public LadderGameResults match(LadderResults ladderResults) {
        return new LadderGameResults(Stream.iterate(0, i -> i < users.size(), i -> i + 1)
                .collect(Collectors.toMap(users::getUser,
                        i -> ladderRewards.getLadderReward(ladderResults.getResultPosition(i)))));

    }
}
