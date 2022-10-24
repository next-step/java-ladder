package nextstep.ladder.Model;

import java.util.Objects;

public class Reward {

    private static final String REWARD_IS_NOT_NULL_OR_BLANK_ERROR = "보상을 정할 때 Null 혹은 빈값을 올 수 없습니다.";
    private static final int STANDARD_COMMON_LENGTH = 5;
    private final String reward;

    public Reward(String reward) {
        validate(reward);
        this.reward = reward;
    }

    private void validate(String name) {
        if (isNullOrBlank(name)) {
            throw new IllegalArgumentException(REWARD_IS_NOT_NULL_OR_BLANK_ERROR);
        }
    }

    private boolean isNullOrBlank(String name) {
        return name == null || name.isEmpty();
    }

    @Override
    public String toString() {
        if (reward.length() < STANDARD_COMMON_LENGTH) {
            return reward + " ".repeat(STANDARD_COMMON_LENGTH - reward.length());
        }
        return reward;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reward)) return false;
        Reward reward1 = (Reward) o;
        return Objects.equals(reward, reward1.reward);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reward);
    }
}
