package nextstep.ladder.domain.reward;

import java.util.Objects;

public class Reward {
    private String reward;

    public Reward(String reward) {
        if (reward == null || reward.isBlank()) {
            throw new IllegalArgumentException("보상은 null이거나 빈값일 수 없습니다. reward=" + reward);
        }
        this.reward = reward;
    }

    public String value() {
        return reward;
    }

    @Override
    public String toString() {
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
