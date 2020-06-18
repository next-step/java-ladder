package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class GameResult {
    private final Map<String, Reward> result;

    public GameResult() {
        this.result = new HashMap<>();
    }

    public void add(String name, Reward reward) {
        this.result.put(name, reward);
    }

    public Map<String, Reward> getResult() {
        return result;
    }
}
