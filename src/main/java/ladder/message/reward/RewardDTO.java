package ladder.message.reward;

import ladder.core.message.Request;

public class RewardDTO implements Request {
    private String reward;
    
    public RewardDTO(String reward) {
        this.reward = reward;
    }
    
    public String getReward() {
        return reward;
    }
    
    public void setReward(String reward) {
        this.reward = reward;
    }
}
