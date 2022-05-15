package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public static Ladder of(int countOfLines, int height) {
        return new Ladder(
                IntStream.range(0, countOfLines)
                        .mapToObj(i -> Line.of(height))
                        .collect(Collectors.toList())
        );
    }

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }
}
