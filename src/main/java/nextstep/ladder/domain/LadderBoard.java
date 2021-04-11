package nextstep.ladder.domain;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Lane;
import nextstep.ladder.domain.reward.Reward;
import nextstep.ladder.domain.reward.Rewards;
import nextstep.ladder.dto.LadderDto;
import nextstep.ladder.dto.RewardsDto;

public class LadderBoard {

    private final Ladder ladder;
    private final Rewards rewards;

    public LadderBoard(Ladder ladder, Rewards rewards) {
        this.ladder = ladder;
        this.rewards = rewards;
    }

    public Reward getReward(Lane lane) {
        return rewards.getReward(ladder.passThrough(lane));
    }

    public LadderDto exportLadder() {
        return ladder.export();
    }

    public RewardsDto exportRewards() {
        return rewards.export();
    }

}
