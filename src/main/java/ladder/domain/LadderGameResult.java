package ladder.domain;

import ladder.domain.member.Member;
import ladder.domain.reward.Reward;

public class LadderGameResult {
    private final Member member;
    private final Reward reward;

    public LadderGameResult(Member member, Reward reward) {
        this.member = member;
        this.reward = reward;
    }

    Member getMember() {
        return member;
    }

    Reward getReward() {
        return reward;
    }

    @Override
    public String toString() {
        return member + " : " + reward;
    }
}
