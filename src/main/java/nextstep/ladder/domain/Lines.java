package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lines {
    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines from(List<Points> allPoints) {
        return new Lines(allPoints.stream()
                .map(Line::new)
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
}
