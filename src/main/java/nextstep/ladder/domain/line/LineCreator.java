package nextstep.ladder.domain.line;

import nextstep.ladder.utils.RandomUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LineCreator {

    private static final int ZERO = 0;

    public static List<Line> createLineList(int countOfPlayer, int countOfLine) {
        return IntStream.range(ZERO, countOfLine)
                .mapToObj((i) -> Line.from(RandomUtils.getBooleanList(countOfPlayer)))
                .collect(Collectors.toList());
    }
}
