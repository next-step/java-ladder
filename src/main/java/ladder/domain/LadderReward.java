package ladder.domain;

import java.util.Objects;

public class LadderReward {
    private final String reward;

    public LadderReward(final String reward) {
        this.reward = reward;
    }

    @Override
    public String toString() {
        return reward;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderReward)) return false;
        LadderReward that = (LadderReward) o;
        return Objects.equals(reward, that.reward);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reward);
    }
}
