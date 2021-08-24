package ladder.view;

import ladder.domain.Participant;
import ladder.domain.Results;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GameResult {
    private final Map<String, String> gameResult;

    private GameResult(Map<String, String> gameResult) {
        this.gameResult = gameResult;
    }

    public static GameResult of(Participant participant, Results finalResults) {
        Map<String, String> gameResult = new HashMap<>();

        List<String> participantList = participant.getList();
        List<String> finalResultsList = finalResults.getList();

        for (int i = 0; i < participant.size(); i++) {
            gameResult.put(participantList.get(i), finalResultsList.get(i));
        }

        return new GameResult(gameResult);
    }

    public Map<String, String> getGameResult() {
        return gameResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult that = (GameResult) o;
        return Objects.equals(gameResult, that.gameResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameResult);
    }
}
