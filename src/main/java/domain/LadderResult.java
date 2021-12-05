package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LadderResult {
    private final Map<Position, String> results;

    public LadderResult(List<String> ladderResult) {
        this.results = new HashMap<>();

        IntStream.range(0, ladderResult.size())
                .forEach(i -> results.put(new Position(i), ladderResult.get(i)));
    }

    public String result(Position position) {
        return results.get(position);
    }
}
