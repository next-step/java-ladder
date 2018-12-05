package ladder.model;

import java.util.Objects;

public class Reward {
    private static final int REWARD_LIMIT_LENGTH = 5;

    private String reward;


    private Reward(String reward) {
        validation(reward);
        this.reward = reward;
    }

    public static Reward of(String reward) {
        return new Reward(reward);
    }

    public String getReward() {
        return reward;
    }

    private void validation(String name) {
        if(name.isEmpty() || name.length() > REWARD_LIMIT_LENGTH) {
            throw new IllegalArgumentException();
        }
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

    @Override
    public String toString() {
        return "Reward{" +
                "reward='" + reward + '\'' +
                '}';
    }
}
