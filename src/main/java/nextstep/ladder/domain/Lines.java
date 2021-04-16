package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {
    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines from(List<CrossingPoints> allCrossingPoints) {
        return new Lines(allCrossingPoints.stream()
                .map(Line::new)
                .collect(Collectors.toList()));
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public List<List<Boolean>> linesConnection() {
        return lines.stream()
                .map(Line::crossingPoints)
                .map(CrossingPoints::pointsConnection)
                .collect(Collectors.toList());
    }

    public int size() {
        return lines.size();
    }
}
