package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lines {

    private static int MIN_HEIGHT = 2;
    private static final String MIN_HEIGHT_ERROR_MSG = "높이는 2 이상 이여야합니다.";

    private final List<Line> lines;

    public Lines(int height, int connectionLineCount) {
        assertHeight(height);
        lines = createLines(height, connectionLineCount);
    }

    private List<Line> createLines(int height, int connectionLineCount) {
        return Stream
                .generate(() -> new Line(connectionLineCount))
                .limit(height)
                .collect(Collectors.toList());
    }

    public List<Line> getValue() {
        return new ArrayList<>(lines);
    }

    private void assertHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException(MIN_HEIGHT_ERROR_MSG);
        }
    }
}
