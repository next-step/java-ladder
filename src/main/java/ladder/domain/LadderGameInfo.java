package ladder.domain;

import ladder.domain.member.Member;
import ladder.domain.member.MemberGroup;
import ladder.domain.reward.Reward;
import ladder.domain.reward.Rewards;

import java.util.List;

public class LadderGameInfo {
    private final MemberGroup memberGroup;
    private final Rewards rewards;

    public LadderGameInfo(MemberGroup memberGroup, Rewards rewards) {
        validateLadderGameInfo(memberGroup, rewards);

        this.memberGroup = memberGroup;
        this.rewards = rewards;
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

    Reward getReward(int index) {
        return this.rewards.getReward(index);
    }

    int getIndexOfMember(Member member) {
        return this.memberGroup.getIndexOfMember(member);
    }

    int getLadderWidthForMembers() {
        return this.memberGroup.getNumberOfMembers() - 1;
    }

    private void validateLadderGameInfo(MemberGroup memberGroup, Rewards rewards) {
        if (memberGroup.getNumberOfMembers() != rewards.getNumberOfRewards()) {
            throw new IllegalArgumentException("The number of members and rewards doesn't match");
        }
    }
}
