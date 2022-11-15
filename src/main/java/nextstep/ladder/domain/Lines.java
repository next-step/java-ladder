package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lines {

    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return this.lines.stream()
                .map(Line::getPoints)
                .map(Line::new)
                .collect(Collectors.toList());
    }
}
