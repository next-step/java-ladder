package ladder.message;

import ladder.core.message.Message;
import ladder.domain.ladder.LadderModel;

import java.util.List;

public class LadderResultMessage extends Message {
    private final List<String> gamerNames;
    private final List<String> rewards;
    private final LadderModel ladderModel;
    
    public LadderResultMessage(List<String> gamerNames, LadderModel ladderModel, List<String> rewards) {
        this.gamerNames = gamerNames;
        this.ladderModel = ladderModel;
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
    
    public LadderModel getLadderModel() {
        return ladderModel;
    }
}
