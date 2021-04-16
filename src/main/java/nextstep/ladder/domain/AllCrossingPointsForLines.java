package nextstep.ladder.domain;

import nextstep.ladder.strategy.DirectionStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AllCrossingPointsForLines {
    private final DirectionStrategy directionStrategy;

    public AllCrossingPointsForLines(DirectionStrategy directionStrategy) {
        this.directionStrategy = directionStrategy;
    }

    public List<CrossingPoints> allCrossingPoints(int countOfPlayer, int height) {
        return allCrossingPoints(new CountOfPlayer(countOfPlayer), new LadderHeight(height));
    }

    public List<CrossingPoints> allCrossingPoints(CountOfPlayer countOfPlayer, LadderHeight ladderHeight) {
        List<CrossingPoints> allCrosses = IntStream.range(0, ladderHeight.value())
                .mapToObj((i) -> new CrossingPoints(countOfPlayer, directionStrategy))
                .collect(Collectors.toList());

        return Collections.unmodifiableList(allCrosses);
    }
}
