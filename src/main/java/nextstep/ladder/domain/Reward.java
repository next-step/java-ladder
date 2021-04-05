package nextstep.ladder.domain;

import java.util.Objects;

public class Reward {

    public static final String GUIDE_ERR_REWARD_EMPTY = "값이 존재하지 않습니다.";
    private final String value;

    public Reward(String value) {
        this.value = value;
    }

    public static Reward valueOf(String reward) {
        if(isNullOrEmpty(reward)) {
            throw new IllegalArgumentException(GUIDE_ERR_REWARD_EMPTY);
        }
        return new Reward(reward);
    }

    private static boolean isNullOrEmpty(String reward) {
        return Objects.isNull(reward) || reward.isEmpty();
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

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
