package ladder.domain;

import ladder.domain.member.Member;
import ladder.domain.member.MemberGroup;
import ladder.domain.reward.Reward;
import ladder.domain.reward.Rewards;
import ladder.vo.Length;

import java.util.List;

public class LadderGameInfo {
    private final MemberGroup memberGroup;
    private final Rewards rewards;

    public LadderGameInfo(MemberGroup memberGroup, Rewards rewards) {
        validateLadderGameInfo(memberGroup, rewards);

        this.memberGroup = memberGroup;
        this.rewards = rewards;
    }

    public Reward getReward(int index) {
        return this.rewards.getReward(index);
    }

    List<Member> getMembers() {
        return memberGroup.getMembers();
    }

    MemberGroup getMemberGroup() {
        return memberGroup;
    }

    Rewards getRewards() {
        return rewards;
    }

    Length getLadderWidthForMembers() {
        int ladderWidthForMembers = this.memberGroup.getNumberOfMembers() - 1;
        return new Length(ladderWidthForMembers);
    }

    private void validateLadderGameInfo(MemberGroup memberGroup, Rewards rewards) {
        if (memberGroup.getNumberOfMembers() != rewards.getNumberOfRewards()) {
            throw new IllegalArgumentException("The number of members and rewards doesn't match");
        }
    }
}
