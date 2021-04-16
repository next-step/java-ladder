package nextstep.ladder.domain;

import nextstep.ladder.strategy.DirectionStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CrossingPointsCreator {
    private final DirectionStrategy directionStrategy;

    public CrossingPointsCreator(DirectionStrategy directionStrategy) {
        this.directionStrategy = directionStrategy;
    }

    public List<CrossingPoints> create(int countOfPlayer, int height) {
        return create(new CountOfPlayer(countOfPlayer), new LadderHeight(height));
    }

    public List<CrossingPoints> create(CountOfPlayer countOfPlayer, LadderHeight ladderHeight) {
        List<CrossingPoints> allCrosses = IntStream.range(0, ladderHeight.value())
                .mapToObj((i) -> new CrossingPoints(countOfPlayer, directionStrategy))
                .collect(Collectors.toList());

        return Collections.unmodifiableList(allCrosses);
    }
}
