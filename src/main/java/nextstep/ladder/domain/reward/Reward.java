package nextstep.ladder.domain.reward;

import nextstep.ladder.domain.exceptions.InvalidRewardArgumentException;

import java.util.Objects;

public class Reward {
    private static final int MAX_REWARD_NAME_LENGTH = 5;

    private String name;

    public Reward(String rewardName) {
        validate(rewardName);
        this.name = rewardName;
    }

    public String getName() {
        return this.name;
    }

    private void validate(String rewardName) {
        validateNull(rewardName);
        validateEmpty(rewardName);
        validateLength(rewardName);
    }

    private void validateNull(String rewardName) {
        if (rewardName == null) {
            throw new InvalidRewardArgumentException("Reward name argument must not be null");
        }
    }

    private void validateEmpty(String rewardName) {
        if (rewardName.trim().isEmpty()) {
            throw new InvalidRewardArgumentException("Reward name argument must not be empty");
        }
    }

    private void validateLength(String rewardName) {
        if (rewardName.trim().length() > MAX_REWARD_NAME_LENGTH) {
            throw new InvalidRewardArgumentException("Reward name length must smaller than 5");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reward reward = (Reward) o;
        return Objects.equals(name, reward.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
