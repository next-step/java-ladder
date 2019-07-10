package ladder.message.result;

import ladder.core.message.Message;
import ladder.domain.ladder.Ladder;

import java.util.List;

public class ResultMessage extends Message {
    private final List<String> gamerNames;
    private final List<String> rewards;
    private final Ladder ladder;
    
    public ResultMessage(List<String> gamerNames, Ladder ladder, List<String> rewards) {
        this.gamerNames = gamerNames;
        this.ladder = ladder;
        this.rewards = rewards;
    }
    
    @Override
    public boolean isResultStep() {
        return true;
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
