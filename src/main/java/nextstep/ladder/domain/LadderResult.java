package nextstep.ladder.domain;

import java.util.Objects;

public class LadderResult {
    private final Member member;
    private final Reward reward;

    public LadderResult(Member member, Reward reward) {
        this.member = member;
        this.reward = reward;
    }

    public boolean isMember(String member) {
        return this.member.getName().equals(member);
    }

    public String getMemberName() {
        return member.getName();
    }

    public String getReward() {
        return reward.getReward();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderResult that = (LadderResult) o;
        return Objects.equals(member, that.member) && Objects.equals(reward, that.reward);
    }

    @Override
    public int hashCode() {
        return Objects.hash(member, reward);
    }
}
