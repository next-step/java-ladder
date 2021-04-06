package nextstep.ladder.service;

import nextstep.ladder.wrapper.Ladder;
import nextstep.ladder.wrapper.LadderResult;
import nextstep.ladder.wrapper.LadderRewards;
import nextstep.ladder.wrapper.Participants;

public class LadderService {

    private LadderService() {
    }

    public static LadderResult rideLadder(
            final Participants participants, final Ladder ladder, final LadderRewards ladderRewards) {
        return participants.findReward(ladder, ladderRewards);
    }
}
