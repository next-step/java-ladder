package ladder.step2.domain;

import ladder.step2.domain.strategy.LineCreateStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderFactory {
    public static Ladder of(int numberOfPlayers, int ladderHeight, LineCreateStrategy lineCreateStrategy) {
        return new Ladder(createLines(numberOfPlayers, ladderHeight, lineCreateStrategy));
    }
    
    private static List<Line> createLines(int numberOfPlayers, int ladderHeight, LineCreateStrategy lineCreateStrategy) {
        return IntStream.range(0, ladderHeight)
                .mapToObj(count -> lineCreateStrategy.createLine(numberOfPlayers))
                .collect(Collectors.toList());
    }
}
