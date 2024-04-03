package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderFactory {

    public static Ladder of(int pointSize, int height) {
        return Ladder.of(createLines(pointSize, height));
    }

    private static List<Line> createLines(int pointSize, int height) {
        return Stream.generate(() -> LineFactory.of(pointSize))
                .limit(height)
                .collect(Collectors.toList());
    }

}
