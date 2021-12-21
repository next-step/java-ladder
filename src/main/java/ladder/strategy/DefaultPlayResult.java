package ladder.strategy;

import ladder.domain.ladder.Ladder;
import ladder.domain.result.ExecutionResults;
import ladder.domain.user.LadderPlayers;

import java.util.HashMap;
import java.util.Map;

public class DefaultPlayResult implements PlayResult {

    private final Ladder ladder;

    public DefaultPlayResult(Ladder ladder) {
        this.ladder = ladder;
    }

    @Override
    public Map<String, String> play(LadderPlayers players, ExecutionResults results) {
        Map<String, String> result = new HashMap<>();
        for (int num = 0; num < players.size(); num++) {
            int findIndex = ladder.move(num);
            result.put(players.getPlayerNames().get(num), results.getResults().get(findIndex));
        }
        return result;
    }

}
