package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lines {

    private final List<Line> lines;

    public Lines(int height, int connectionLineCount) {
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
}
