package ladder.domain;

import ladder.view.ResultView;

import java.util.Objects;

public class Reward {
    private final String reward;

    public Reward(String reward) {
        this.reward = reward;
    }

    public String withWhiteSpaceReward() {
        if (reward.length() > ResultView.AISLE_WIDTH + 1) {
            return "";
        }
        return String.format("%-8s", reward);
    }

    @Override
    public String toString() {
        return reward;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Reward reward1 = (Reward) o;
        return Objects.equals(reward, reward1.reward);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reward);
    }
}
