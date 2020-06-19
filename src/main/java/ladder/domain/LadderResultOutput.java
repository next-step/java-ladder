package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderResultOutput {

    private Map<String, String> resultOutput = new HashMap<>();

    public LadderResultOutput(Players players, Rewards rewards) {
        for (Position position : players.getPlayerResultPosition()) {
            resultOutput.put(players.getPlayerByPosition(position).getName(),
                    rewards.getResultByPositionIndex(position.getIndex()).getRewardInfo());
        }
    }

    public String getResultTargetOutput(String input) {
        return resultOutput.get(input);
    }

    public Map<String, String> getResultOutput() {
        return resultOutput;
    }
}
