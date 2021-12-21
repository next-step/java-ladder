package ladder.domain;


import java.util.HashMap;
import java.util.Map;

public class LadderResult {
    private final Map<String, String> ladderResult;
    private final Results results;
    private final Players players;

    private LadderResult(Players players, Results results) {
        this(players, results, new HashMap<>());
    }

    private LadderResult(Players players, Results results, Map<String, String> ladderResult) {
        this.players = players;
        this.results = results;
        this.ladderResult = ladderResult;
    }

    public static LadderResult of(Players players, Results results) {
        if (players.countOfPlayers() != results.countOfResult()) {
            throw new IllegalArgumentException();
        }
        return new LadderResult(players, results);
    }

}
