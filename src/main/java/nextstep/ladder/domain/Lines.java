package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lines {
    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
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
