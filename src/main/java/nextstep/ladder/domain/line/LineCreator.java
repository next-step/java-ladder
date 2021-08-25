package nextstep.ladder.domain.line;

import nextstep.ladder.utils.RandomUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LineCreator {

    public static List<Line> createLineList(int countOfPlayer, int countOfLine) {
        return IntStream.range(0, countOfLine)
                .mapToObj((i) -> Line.from(RandomUtils.getBooleanList(countOfPlayer)))
                .collect(Collectors.toList());
    }
}
