package nextstep.ladder.domain.line;

import nextstep.ladder.domain.line.Line;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lines {

    private static int MIN_HEIGHT = 2;
    private static final String MIN_HEIGHT_ERROR_MSG = "높이는 2 이상 이여야합니다.";

    private final List<Line> lines;

    public Lines(List<Line> lines) {
        assertHeight(lines.size());
        this.lines = lines;
    }

    public Lines(int height, int connectionLineCount) {
        this(createLines(height, connectionLineCount));
    }

    private static List<Line> createLines(int height, int connectionLineCount) {
        return Stream
                .generate(() -> new Line(connectionLineCount))
                .limit(height)
                .collect(Collectors.toList());
    }

    public int move(int startPosition) {
        int nextPosition = startPosition;
        for (Line line : lines) {
            nextPosition = line.move(nextPosition);
        }

        return nextPosition;
    }

    public List<Line> getValue() {
        return Collections.unmodifiableList(lines);
    }

    private void assertHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException(MIN_HEIGHT_ERROR_MSG);
        }
    }
}
