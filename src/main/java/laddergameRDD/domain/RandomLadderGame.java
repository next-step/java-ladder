package laddergameRDD.domain;

import laddergameRDD.engine.LadderGame;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RandomLadderGame implements LadderGame {
    @Override
    public List<GameResult> play(int rowCount, List<String> users, List<String> results) {
        Ladder ladder = new Ladder(rowCount, users.size(), new RandomSelectStrategy());
        Map<Integer, Integer> integerResults = new LinkedHashMap<>();
        for (int currentColumn = 0; currentColumn < users.size(); ++currentColumn) {
            integerResults.put(currentColumn, ladder.play(currentColumn));
        }

        GameResults gameResults = new GameResults(users, results);
        return gameResults.makeGameResults(integerResults);
    }
}
