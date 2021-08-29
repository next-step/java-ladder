package nextstep.ladder.domain.impl.line;

import nextstep.ladder.domain.engine.LineCreator;
import nextstep.ladder.utils.RandomUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLineCreator implements LineCreator {

    private static final int ZERO = 0;

    public List<LadderLine> create(int countOfPlayer, int countOfLine) {
        return IntStream.range(ZERO, countOfLine)
                .mapToObj((i) -> LadderLine.from(RandomUtils.getBooleanList(countOfPlayer)))
                .collect(Collectors.toList());
    }
}
