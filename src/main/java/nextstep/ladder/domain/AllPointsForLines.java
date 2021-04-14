package nextstep.ladder.domain;

import nextstep.ladder.strategy.DirectionStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AllPointsForLines {
    private final DirectionStrategy directionStrategy;

    public AllPointsForLines(DirectionStrategy directionStrategy) {
        this.directionStrategy = directionStrategy;
    }

    public List<Points> allPoints(int countOfPlayer, int height) {
        return allPoints(new CountOfPlayer(countOfPlayer), new LadderHeight(height));
    }

    public List<Points> allPoints(CountOfPlayer countOfPlayer, LadderHeight ladderHeight) {
        List<Points> allPoints = IntStream.range(0, ladderHeight.value())
                .mapToObj((i) -> new Points(countOfPlayer, directionStrategy))
                .collect(Collectors.toList());

        return Collections.unmodifiableList(allPoints);
    }
}
