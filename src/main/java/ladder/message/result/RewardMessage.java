package ladder.message.result;

import ladder.core.message.Message;

public class RewardMessage implements Message {
    private final String reward;
    
    public RewardMessage(String reward) {
        this.reward = reward;
    }
    
    public String getReward() {
        return reward;
    }
}
