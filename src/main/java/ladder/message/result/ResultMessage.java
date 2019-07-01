package ladder.message.result;

import ladder.core.message.Message;
import ladder.domain.ladder.Ladder;
import ladder.domain.gamer.Gamers;

public class ResultMessage extends Message {
    private final Gamers gamers;
    private final Ladder ladder;
    
    public ResultMessage(Gamers gamers, Ladder ladder) {
        this.gamers = gamers;
        this.ladder = ladder;
    }
    
    public Gamers getGamers() {
        return gamers;
    }
    
    public Ladder getLadder() {
        return ladder;
    }
    
    @Override
    public boolean isResultStep() {
        return true;
    }
}
