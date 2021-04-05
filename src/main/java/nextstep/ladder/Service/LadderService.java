package nextstep.ladder.Service;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.LadderRewards;
import nextstep.ladder.domain.Participants;

public class LadderService {

    public static LadderResult rideLadder(Participants participants, Ladder ladder, LadderRewards ladderRewards) {
        return participants.findReward(ladder, ladderRewards);
    }
}
