package ladder.message.result;

import ladder.core.message.Message;

public class RewardMessage extends Message {
    private final String reward;
    
    public RewardMessage(String reward) {
        this.reward = reward;
    }
    
    @Override
    public boolean isRewardStep() {
        return true;
    }
    
    public String getReward() {
        return reward;
    }
}
