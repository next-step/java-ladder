package nextstep.ladder.domain;

import java.util.Objects;

public class Reward {

    private static final String REWARD_VALIDATE_MESSAGE = "결과는 빈칸일 수 없습니다";

    private final String reward;

    public Reward(String reward) {
        this.reward = reward;
        validateReward();
    }

    private void validateReward() {
        if (reward.isEmpty() || reward.trim().isEmpty()) {
            throw new IllegalArgumentException(REWARD_VALIDATE_MESSAGE);
        }
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
