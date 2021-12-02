package step2.domain;

import java.util.Arrays;

public class Rewards {
    public static final String COMMA = ",";

    private final String[] rewards;

    private Rewards(String[] rewards) {
        this.rewards = rewards;
    }

    public static Rewards of(String rewards) {
        return new Rewards(split(rewards));
    }

    public String getBy(int position) {
        validatePosition(position);
        return rewards[position];
    }

    private void validatePosition(int position) {
        if (rewards.length <= position) {
            throw new IllegalArgumentException("보상이 존재하지 않습니다.");
        }
    }

    private static String[] split(String rewards) {
        return rewards.split(COMMA);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rewards rewards1 = (Rewards) o;
        return Arrays.equals(rewards, rewards1.rewards);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(rewards);
    }
}
