package ladder.message.result;

import ladder.core.message.Message;
import ladder.domain.ladder.Ladder;

import java.util.List;

public class ResultMessage implements Message {
    private final List<String> gamerNames;
    private final Ladder ladder;
    private final List<String> rewards;
    
    public ResultMessage(List<String> gamerNames, Ladder ladder, List<String> rewards) {
        this.gamerNames = gamerNames;
        this.ladder = ladder;
        this.rewards = rewards;
    }
    
    public List<String> getGamerNames() {
        return gamerNames;
    }
    
    public List<String> getRewardNames() {
        return rewards;
    }
    
    public Ladder getLadder() {
        return ladder;
    }
}
