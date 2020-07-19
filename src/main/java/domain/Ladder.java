package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int countOfPlayer, LadderLevel ladderLevel) {
        this.lines = IntStream.range(0, ladderLevel.getHeight())
                .mapToObj(i -> Line.of(countOfPlayer, ladderLevel))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return lines;
    }

    public MatchingResult play() {
        int personSize = lines.get(0).getPersonSize();
        Map<Integer, Integer> matchingResult = new HashMap<>();
        for (int i = 0; i < personSize ; i++) {
            matchingResult.put(i, getLadderResultIndex(i));
        }

        return MatchingResult.of(matchingResult);
    }

    public int getLadderResultIndex(int playerIndex) {
        int point = playerIndex;

        for (Line line : lines) {
            point = line.nextPointIndex(point);
        }

        return point;
    }
}
