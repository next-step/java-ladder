package laddergameRDD.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RandomLadderGame{
    public List<GameResult> play(Ladder ladder, List<String> users, List<String> results) {
        Map<Integer, Integer> integerResults = new LinkedHashMap<>();
        for (int currentColumn = 0; currentColumn < users.size(); ++currentColumn) {
            integerResults.put(currentColumn, ladder.play(currentColumn));
        }

        GameResults gameResults = new GameResults(users, results);
        return gameResults.makeGameResults(integerResults);
    }
}
