package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderResultOutput {

    private Map<String, String> resultOutput = new HashMap<>();

    public LadderResultOutput(Players players, LadderResults ladderResults) {
        for (Position position : players.getPlayerResultPosition()) {
            resultOutput.put(players.getPlayerByPosition(position).getName(),
                    ladderResults.getResultByPositionIndex(position.getIndex()).getResultInfo());
        }
    }

    public String getResultTargetOutput(String input) {
        return resultOutput.get(input);
    }

    public Map<String, String> getResultOutput() {
        return resultOutput;
    }
}
