package step2.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class GameHistory {
    private final Map<Integer, Integer> history = new LinkedHashMap<>();

    private GameHistory() {
    }

    public static GameHistory of() {
        return new GameHistory();
    }

    public void record(Integer participantPosition, Integer rewardPosition) {
        history.put(participantPosition, rewardPosition);
    }

    public Map<Integer, Integer> get() {
        return history;
    }
}
