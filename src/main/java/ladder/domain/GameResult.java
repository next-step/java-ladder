package ladder.domain;

import lombok.Builder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class GameResult {
    private final Map<String, String> gameResults;

    @Builder
    private GameResult(Map<Integer, Integer> ladderResults, Players players, Rewards rewards) {
        this.gameResults = mappingResult(ladderResults, players, rewards);
    }

    public Optional<String> getResult(String playerName) {
        return Optional.ofNullable(gameResults.get(playerName));
    }

    public Map<String, String> mappingResult(Map<Integer, Integer> ladderResults, Players players, Rewards rewards) {
        Map<String, String> result = new HashMap<>();
        for (int index = 0; index < ladderResults.size(); index++) {
            result.put(players.getPlayer(index).getName(), rewards.getReward(ladderResults.get(index)));
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult that = (GameResult) o;
        return Objects.equals(gameResults, that.gameResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameResults);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        gameResults.keySet().stream()
                .forEach(playerName -> stringBuilder.append(playerName + " : " + gameResults.get(playerName) + "\n"));
        return stringBuilder.toString();
    }
}
