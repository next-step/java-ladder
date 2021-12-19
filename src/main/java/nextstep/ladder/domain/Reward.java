package nextstep.ladder.domain;

import java.util.Objects;

public class Reward {
    private static final String EXCEPTION_MESSAGE_REWARD = "결과를 입력하세요.";

    private final String reward;

    public Reward(String reward) {
        validateReward(reward);
        this.reward = reward;
    }

    private void validateReward(String name) {
        if (Objects.isNull(name) || name.length() == 0) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_REWARD);
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
