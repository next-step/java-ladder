package ladder.message.response.result;

import ladder.core.message.Response;
import ladder.domain.ladder.Ladder;

import java.util.List;

public class Result extends Response {
    private final List<String> gamerNames;
    private final Ladder ladder;
    private final List<String> rewards;
    
    public Result(List<String> gamerNames, Ladder ladder, List<String> rewards) {
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
    
    @Override
    public boolean isResultStep() {
        return true;
    }
}
