package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderResults {

    private final Map<String, String> ladderGameOutcomes = new HashMap<>();
    private final List<String> executionResults;

    public LadderResults(List<String> executionResults) {
        this.executionResults = executionResults;
    }

    public void processLadderGameOutcomes(Players players, Ladder ladder) {
        for (int player = 0; player < players.size(); player++) {
            int finalPosition = ladder.move(player);
            ladderGameOutcomes.put(players.playerName(player), executionResults.get(finalPosition));
        }
    }

    public Map<String, String> ladderGameOutcomes() {
        return ladderGameOutcomes;
    }

    public List<String> executionResults() {
        return executionResults;
    }
}
