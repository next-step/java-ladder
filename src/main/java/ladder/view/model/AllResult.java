package ladder.view.model;

import ladder.domain.gamer.info.Gamer;
import ladder.domain.reward.info.Reward;

import java.util.Map;

public class AllResult {
    private final static String EMPTY_STRING = "";
    private final static String RESULT_DELIMITER = ":";
    private final static String ENTER = System.getProperty("line.separator");
    
    private Map<Gamer, Reward> results;
    
    private AllResult(Map<Gamer, Reward> results) {
        this.results = results;
    }
    
    public static AllResult of(Map<Gamer, Reward> results) {
        return new AllResult(results);
    }
    
    public String getAllResultString() { 
        return results.keySet().stream()
            .map(gamer -> gamer.getName() + RESULT_DELIMITER + results.get(gamer).getReward())
            .reduce((result1, result2) -> result1 + ENTER + result2)
            .orElse(EMPTY_STRING);
    }
}
