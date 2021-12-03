package step2.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

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

    public Map<String, String> save(Participants participants, Rewards rewards) {
        return history.entrySet().stream().collect(Collectors.toMap(
                entry -> participants.getBy(entry.getKey()).getName(),
                entry -> rewards.getBy(entry.getValue()).getReward()));
    }
}
