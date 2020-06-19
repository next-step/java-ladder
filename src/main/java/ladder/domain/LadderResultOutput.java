package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderResultOutput {

    private Map<String, String> resultOutput = new HashMap<>();

    public LadderResultOutput(Players players, Rewards rewards) {
        for (int i = 0; i < rewards.getResultCount(); i++) {
            resultOutput.put(players.getPlayerName(i),rewards.getRewardInfo(i));
        }
    }

    public String getResultTargetOutput(String input) {
        return resultOutput.get(input);
    }

    public Map<String, String> getResultOutput() {
        return resultOutput;
    }
}
