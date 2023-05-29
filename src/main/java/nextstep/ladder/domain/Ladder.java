package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final int verticalLineCount;
    private final Lines lines;

    public Ladder(int verticalLineCount, Lines lines) {
        this.verticalLineCount = verticalLineCount;
        this.lines = lines;
    }

    public Ladder(int verticalLineCount, int height) {
        this(verticalLineCount, new Lines(generateLadder(verticalLineCount, height)));
    }

    private static List<Line> generateLadder(int verticalLineCount, int height) {
        return Stream.generate(() -> new Line(verticalLineCount))
                .limit(height)
                .collect(Collectors.toList());
    }

    public Lines lines() {
        return lines;
    }
}
