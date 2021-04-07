package nextstep.ladder.service;

import nextstep.ladder.domain.Position;
import nextstep.ladder.domain.Reward;
import nextstep.ladder.domain.User;
import nextstep.ladder.wrapper.Ladder;
import nextstep.ladder.wrapper.LadderResult;
import nextstep.ladder.wrapper.LadderRewards;
import nextstep.ladder.wrapper.Participants;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class LadderService {

    private LadderService() {}

    public static LadderResult rideLadder(
            final Participants participants, final Ladder ladder, final LadderRewards ladderRewards) {
        Map<User, Reward> result = new LinkedHashMap<>();
        Set<User> users = participants.getUsers();

        for (User user : users) {
            Position rewardPosition = ladder.findEndPosition(user.position());
            Reward reward = ladderRewards.findReward(rewardPosition);
            result.put(user, reward);
        }

        return LadderResult.valueOf(result);
    }
}
