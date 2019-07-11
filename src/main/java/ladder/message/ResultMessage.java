package ladder.message;

import ladder.core.message.Message;
import ladder.domain.gamer.info.Gamer;
import ladder.domain.reward.info.Reward;

import java.util.LinkedHashMap;
import java.util.Map;

public class ResultMessage extends Message {
    private final String reward;
    private final Map<Gamer, Reward> results;
    
    public ResultMessage(Reward reward) {
        this.reward = reward.getReward();
        this.results = new LinkedHashMap<>();
    }
    
    public ResultMessage(Map<Gamer, Reward> results) {
        this.results = results;
        this.reward = "";
    }
    
    @Override
    public boolean isRewardStep() {
        return true;
    }
    
    public String getReward() {
        return reward;
    }
    
    public Map<Gamer, Reward> getResults() {
        return results;
    }
}
