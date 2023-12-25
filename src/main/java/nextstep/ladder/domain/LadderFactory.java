package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderFactory {
    public static Ladder create(LineCreator lineCreator, int countOfMembers, int height) {
        List<Line> lines = IntStream.range(0, height)
                .mapToObj((i) -> lineCreator.create(countOfMembers))
                .collect(Collectors.toList());
        return new Ladder(countOfMembers, lines);
    }
}
