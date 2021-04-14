package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {
    private static final int FIRST_LINE_INDEX = 0;

    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines from(List<Points> allPoints) {
        return new Lines(IntStream.range(0, allPoints.size())
                .mapToObj((i) -> new Line(i, allPoints.get(i)))
                .collect(Collectors.toList()));
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public List<List<Boolean>> linesConnection() {
        return lines.stream()
                .map(Line::points)
                .map(Points::pointsConnection)
                .collect(Collectors.toList());
    }

    public int size() {
        return lines.size();
    }

    public Line firstLine() {
        return lines.get(FIRST_LINE_INDEX);
    }

    public Line nextLine(int lineIndex) {
        return lines.get(lineIndex + 1);
    }
}
