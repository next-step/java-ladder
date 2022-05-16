package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lines {
    private static final String DELIMITER = "";

    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    static Lines of(List<List<Boolean>> lineList) {
        return new Lines(wrap(lineList));
    }

    private static List<Line> wrap(List<List<Boolean>> lineList) {
        return lineList.stream()
                .map(Line::new)
                .collect(Collectors.toList());
    }

    public String getPoints() {
        return this.lines.stream()
                .map(Line::getPoint)
                .collect(Collectors.joining(DELIMITER));
    }
}
