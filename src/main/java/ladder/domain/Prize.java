package ladder.domain;

import java.util.Objects;

public class Prize {

    private final String reward;

    public Prize(String reward) {
        this.reward = reward;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Prize prize = (Prize) o;

        return Objects.equals(reward, prize.reward);
    }

    @Override
    public int hashCode() {
        return reward != null ? reward.hashCode() : 0;
    }
}
