package ladder.domain.reward.info;

import ladder.domain.reward.message.ErrorMessages;
import ladder.util.StringUtils;

public class Reward {
    private final String reward;
    
    private Reward(String reward) {
        if (StringUtils.isEmpty(reward)) {
            throw new IllegalArgumentException(ErrorMessages.CANT_INPUT_EMPTY_STRING.message());
        }
        this.reward = reward;
    }
    
    public static Reward from(String reward) {
        return new Reward(reward);
    }
    
    public String getReward() {
        return reward;
    }
}
