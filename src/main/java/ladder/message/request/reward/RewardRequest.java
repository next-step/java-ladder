package ladder.message.request.reward;

import ladder.core.message.Request;

public class RewardRequest implements Request {
    private String reward;
    
    public RewardRequest(String reward) {
        this.reward = reward;
    }
    
    public String getReward() {
        return reward;
    }
    
    public void setReward(String reward) {
        this.reward = reward;
    }
}
