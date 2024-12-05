package ladder.domain.nextstep;

import ladder.domain.engine.Ladder;
import ladder.domain.engine.LadderResults;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NextStepLadderResults implements LadderResults {

    private final Map<String, String> ladderGameOutcomes = new HashMap<>();
    private final List<String> executionResults;

    private NextStepLadderResults(List<String> executionResults) {
        this.executionResults = executionResults;
    }

    public static LadderResults of(List<String> executionResults) {
        return new NextStepLadderResults(executionResults);
    }

    @Override
    public void processLadderGameOutcomes(Players players, Ladder ladder) {
        for (int player = 0; player < players.size(); player++) {
            int finalPosition = ladder.move(player);
            ladderGameOutcomes.put(players.playerName(player), executionResults.get(finalPosition));
        }
    }

    @Override
    public Map<String, String> ladderGameOutcomes() {
        return ladderGameOutcomes;
    }

    @Override
    public List<String> executionResults() {
        return executionResults;
    }
}
