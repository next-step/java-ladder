package ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GamersResult {
    private final Map<Name, Integer> GamersResults;

    public GamersResult(Map<Name, Integer> gamersResults) {
        GamersResults = gamersResults;
    }

    public static GamersResult createGamersResult(Names names, Ladder ladder) {
        Map<Name, Integer> endResult = findEndPoint(names, ladder);

        return new GamersResult(endResult);
    }

    private static Map<Name, Integer> findEndPoint(Names names, Ladder ladder) {
        Map<Name, Integer> endResults = new HashMap<>();

        for (int i = 0; i < names.countPlayers(); i++) {
            int endPosition = ladder.ladderMove(i);
            endResults.put(names.getName(i), endPosition);
        }

        return endResults;
    }

    public Map<Name, Integer> getGamersResults() {
        return Collections.unmodifiableMap(this.GamersResults);
    }
}
