package nextstep.ladder.domain.line;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import nextstep.ladder.domain.Count;
import nextstep.ladder.domain.RandomLadderPointStrategy;

public class RandomLineStrategy implements LineGenerateStrategy {
    private static final RandomLadderPointStrategy strategy = new RandomLadderPointStrategy();

    @Override
    public List<Boolean> generatePoints(Count count) {
        return Stream.generate(strategy::generatePoint)
                .limit(count.toInt())
                .collect(Collectors.toList());
    }
}
