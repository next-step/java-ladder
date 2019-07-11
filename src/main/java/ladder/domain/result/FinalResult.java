package ladder.domain.result;

import ladder.domain.gamer.Gamers;
import ladder.domain.gamer.info.Gamer;
import ladder.domain.ladder.LadderModel;
import ladder.domain.reward.Rewards;
import ladder.domain.reward.info.Reward;

import java.util.LinkedHashMap;
import java.util.Map;

public class FinalResult {
    private Map<Gamer, Reward> results = new LinkedHashMap<>();
    
    public static FinalResult newInstance() {
        return new FinalResult();
    }
    
    public void goToGoal(Gamers gamers, LadderModel ladderModel, Rewards rewards) {
        gamers.keyStream()
            .forEach(gamer -> results.put(gamer, rewards.getReward(gamer, gamers, ladderModel)));
    }
    
    public int getSize() {
        return results.size();
    }
    
    public Map<Gamer, Reward> getAllResults() {
        return new LinkedHashMap<>(this.results);
    }
    
    public Reward getResult(String gamer) {
        return results.get(Gamer.from(gamer));
    }
}
