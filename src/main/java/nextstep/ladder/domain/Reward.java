package nextstep.ladder.domain;

import nextstep.ladder.domain.exceptions.InvalidRewardArgumentException;

public class Reward {
    private String name;
    private Player player;

    public Reward(String rewardName, Player player) {
        validateRewardName(rewardName);
        this.name = rewardName;
        this.player = player;
    }

    private void validateRewardName(String rewardName) {
        if (rewardName == null) {
            throw new InvalidRewardArgumentException("Reward name argument must not be null");
        }
        if (rewardName.trim().isEmpty()) {
            throw new InvalidRewardArgumentException("Reward name argument must not be empty");
        }
    }
}
