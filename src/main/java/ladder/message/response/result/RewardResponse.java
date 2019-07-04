package ladder.message.response.result;

import ladder.core.message.Response;

public class RewardResponse extends Response{
    private final String reward;
    
    public RewardResponse(String reward) {
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
