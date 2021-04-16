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
                        prizes.get(findLastIndex(playerIndex)))
                );

        return new MatchedResult(result);
    }

    private int findLastIndex(int pointIndex) {
        Line currentLine = lines.firstLine();

        while (currentLine.isNotLast(lines.size())) {
            pointIndex = currentLine.nextPointIndexFrom(pointIndex);
            currentLine = lines.nextLine(currentLine.index());
        }

        pointIndex = currentLine.nextPointIndexFrom(pointIndex);

        return pointIndex;
    }
}
