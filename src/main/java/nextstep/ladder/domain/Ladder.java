package nextstep.ladder.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Ladder {
    private final Lines lines;

    public Ladder(Lines lines) {
        this.lines = lines;
    }

    public int height() {
        return lines.size();
    }

    public List<List<Boolean>> linesConnection() {
        return lines.linesConnection();
    }

    public MatchedResult map(List<String> players, List<String> prizes) {
        Map<String, String> result = new LinkedHashMap<>();

        IntStream.range(0, players.size())
                .forEach((playerIndex) -> result.put(
                        players.get(playerIndex),
                        prizes.get(move(playerIndex)))
                );

        return new MatchedResult(result);
    }

    private int move(int pointIndex) {
        int lastPointIndex = pointIndex;

        for (Line line : lines.lines()) {
            lastPointIndex = line.move(lastPointIndex);
        }

        return lastPointIndex;
    }
}
