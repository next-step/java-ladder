package nextstep.ladder.domain;

import nextstep.ladder.domain.exceptions.InvalidRewardArgumentException;

public class Reward {
    private static final int MAX_REWARD_NAME_LENGTH = 5;

    private String name;
    private Player player;

    public Reward(String rewardName, Player player) {
        validateRewardName(rewardName);
        this.name = rewardName;
        this.player = player;
    }

    private void validateRewardName(String rewardName) {
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
}
