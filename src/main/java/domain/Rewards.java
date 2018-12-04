package domain;

import java.util.Arrays;

import static java.util.Optional.ofNullable;

public class Rewards {

    private final String[] rewards;

    public Rewards(final String[] rewards) {

        ofNullable(rewards).orElseThrow(IllegalArgumentException::new);

        if (rewards.length == 0) {
            throw new IllegalArgumentException();
        }

        for (final String reward : rewards) {
            if (reward == null) {
                throw new IllegalArgumentException();
            }
        }

        this.rewards = rewards;
    }

    public boolean eqRewards(final String[] values) {
        return this.rewards == values;
    }

    public int size() {
        return this.rewards.length;
    }

    public String findReward(final int playerNo) {
        return this.rewards[playerNo];
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Rewards rewards1 = (Rewards) o;
        return Arrays.equals(rewards, rewards1.rewards);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(rewards);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rewards.length; i++) {
            final String reward = rewards[i];
            if (i > 0) {
                sb.append("     ");
            }
            sb.append(reward);
        }
        return sb.toString();
    }

}
