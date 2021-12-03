package step2.domain;

import java.util.Objects;

public class Reward {
    private final String reward;

    private Reward(String reward) {
        this.reward = reward;
    }

    public static Reward of(String reward) {
        return new Reward(reward);
    }

    public String getReward() {
        return reward;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reward reward1 = (Reward) o;
        return Objects.equals(reward, reward1.reward);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reward);
    }
}
