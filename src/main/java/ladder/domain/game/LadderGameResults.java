package ladder.domain.game;

import ladder.domain.player.LadderPlayer;

import java.util.Collections;
import java.util.Map;

public class LadderGameResults {
    private final Map<LadderPlayer, LadderReward> results;

    public LadderGameResults(Map<LadderPlayer, LadderReward> results) {
        this.results = Collections.unmodifiableMap(results);
    }

    public LadderReward getLadderReward(String userName) {
        return results.get(LadderPlayer.create(userName));
    }

    public Map<LadderPlayer, LadderReward> getResults() {
        return Collections.unmodifiableMap(results);
    }
}
