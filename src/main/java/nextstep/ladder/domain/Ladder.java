package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private final List<Line> lines;

    public Ladder(LadderGenerator ladderGenerator) {
        this.lines = ladderGenerator.generate().stream()
                .map(Line::new)
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return lines;
    }
}
