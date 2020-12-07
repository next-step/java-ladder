package ladder.domain;

import ladder.ladderexceptions.InvalidRewardNameException;

import java.util.Objects;

public class Reward {

    private final String reward;

    public Reward(String reward) {
        validateName(reward);
        this.reward = reward;
    }

    private void validateName(String name) {
        if (name.isEmpty()) {
            throw new InvalidRewardNameException();
        }
    }

    public String getReward() {
        return reward;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reward reward = (Reward) o;
        return Objects.equals(this.reward, reward.reward);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reward);
    }
}
