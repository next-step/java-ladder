package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LadderResult {
    private final Map<Position, String> results;
    private final List<String> gameResults;

    public LadderResult(List<String> ladderResult) {
        this.results = new HashMap<>();

        IntStream.range(0, ladderResult.size())
                .forEach(i -> results.put(new Position(i), ladderResult.get(i)));
        gameResults = ladderResult;
    }

    public String result(int point) {
        return gameResults.get(point);
    }

    public String result(Position position) {
        return results.get(position);
    }
}
