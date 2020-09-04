package ladder.domain.reward;

import java.util.Objects;

public class Reward {
    private final String prize;

    public Reward(String prize) {
        this.prize = prize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reward reward = (Reward) o;
        return Objects.equals(prize, reward.prize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prize);
    }
}
