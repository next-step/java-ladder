package nextstep.ladder.domain;

import java.util.Objects;

public class Reward {
    private final String reward;

    public Reward(String reward) {
        validate(reward);
        this.reward = reward;
    }

    private void validate(String reward) {
        if (reward == null || reward.trim().isEmpty()) {
            throw new RuntimeException("보상은 비어있을 수 없습니다.");
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
        return Objects.hashCode(reward);
    }
}
