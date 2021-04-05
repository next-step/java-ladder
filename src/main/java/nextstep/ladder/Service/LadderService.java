package nextstep.ladder.Service;

import nextstep.ladder.domain.*;

import java.util.Map;

public class LadderService {

    public static Map<User, Reward> rideLadder(Participants participants, Ladder ladder, LadderRewards ladderRewards) {
        return participants.findReward(ladder, ladderRewards);
    }
}
