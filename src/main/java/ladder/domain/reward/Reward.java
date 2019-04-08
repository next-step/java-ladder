package ladder.domain.reward;

import org.apache.commons.lang3.StringUtils;

public class Reward {
    private static final int MAX_NAME_LENGTH = 5;

    private final String reward;

    public Reward(String reward) {
        validateReward(reward);
        this.reward = reward;
    }

    private void validateReward(String reward) {
        if (StringUtils.isBlank(reward) || (MAX_NAME_LENGTH < reward.length())) {
            throw new IllegalArgumentException("It's not valid reward : " + reward);
        }
    }

    @Override
    public String toString() {
        return reward;
    }
}
