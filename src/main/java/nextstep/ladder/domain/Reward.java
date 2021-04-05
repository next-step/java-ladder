package nextstep.ladder.domain;

import java.util.Objects;

public class Reward {

    private final String value;

    public Reward(String value) {
        this.value = value;
    }

    public static Reward valueOf(String reward) {
        return new Reward(reward);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reward)) return false;
        final Reward reward = (Reward) o;
        return Objects.equals(value, reward.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
