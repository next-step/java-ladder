package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lines {
    private static final String DELIMITER = "";

    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public String getPoints() {
        return this.lines.stream()
                .map(Line::getPoint)
                .collect(Collectors.joining(DELIMITER));
    }
}
