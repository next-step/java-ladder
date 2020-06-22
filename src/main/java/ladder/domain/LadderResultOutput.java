package ladder.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderResultOutput {

    private Map<String, String> resultOutput = new LinkedHashMap<>();

    public void addResult(String name, String RewardInfo) {
        resultOutput.put(name, RewardInfo);
    }

    public String getResultTargetOutput(String input) {
        return resultOutput.get(input);
    }

    public Map<String, String> getResultOutput() {
        return resultOutput;
    }
}
