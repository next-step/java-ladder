package nextstep.ladder.domain;

import nextstep.ladder.strategy.DirectionStrategy;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final Lines lines;

    public Ladder(int countOfPlayer, int ladderHeight, DirectionStrategy directionStrategy) {
        this(new CountOfPlayer(countOfPlayer), new LadderHeight(ladderHeight), directionStrategy);
    }

    public Ladder(CountOfPlayer countOfPlayer, LadderHeight ladderHeight, DirectionStrategy directionStrategy) {
        this(createWith(countOfPlayer, ladderHeight, directionStrategy));
    }

    private static Lines createWith(CountOfPlayer countOfPlayer, LadderHeight ladderHeight, DirectionStrategy directionStrategy) {
        List<Line> lines = IntStream.range(0, ladderHeight.value())
                .mapToObj((i) -> new Line(countOfPlayer, directionStrategy))
                .collect(Collectors.toList());

        return new Lines(lines);
    }

    public Ladder(Lines lines) {
        this.lines = lines;
    }

    public LadderHeight height() {
        return new LadderHeight(lines.size());
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
