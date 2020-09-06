package nextstep.ladder.domain;

import java.util.Objects;

import static nextstep.ladder.constant.ExceptionMessage.INVALID_REWARD_LENGTH_UNDER_FIVE;

public class Reward extends Position{

    private static final int MAXIMUM_REWARD_NAME_LENGTH = 5;

    private String reward;

    private Reward(String reward, int position) {
        super(position);
        this.reward = reward;

        if (reward.length() > MAXIMUM_REWARD_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_REWARD_LENGTH_UNDER_FIVE);
        }
    }

    public static Reward newInstance(String name, int position) {
        return new Reward(name.trim(), position);
    }

    public String getName() {
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
