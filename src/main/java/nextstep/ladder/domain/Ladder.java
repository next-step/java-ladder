package nextstep.ladder.domain;

import nextstep.ladder.exception.LadderHeightException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    public static final int MIN_LADDER_HEIGHT = 1;
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        validateLadderMaxHeight(lines.size());
        this.lines = lines;
    }

    public static Ladder of(int pointSize, int height) {
        return new Ladder(createLines(pointSize, height));
    }

    public static Ladder of(List<Line> lines) {
        return new Ladder(lines);
    }

    private static List<Line> createLines(int pointSize, int height) {
        return Stream.generate(() -> Line.of(pointSize))
                .limit(height)
                .collect(Collectors.toList());
    }

    private static void validateLadderMaxHeight(int height) {
        if (height < Ladder.MIN_LADDER_HEIGHT) {
            throw new LadderHeightException(height);
        }
    }

    public int getHeight() {
        return this.lines.size();
    }

    public List<Line> getLines() {
        return this.lines;
    }
}
