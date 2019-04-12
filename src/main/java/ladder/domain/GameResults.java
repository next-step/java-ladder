package ladder.domain;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class GameResults {
    List<GameResult> gameResults = new ArrayList<>();

    public GameResults(List<String> inputResults) {
        inputResults.forEach(inputResult -> {
            gameResults.add(new GameResult(inputResult));
        });
    }

    public GameResult getGameResult(int index) {
        return gameResults.get(index);
    }
}
