package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private final List<Line> lineList;

    public Ladder(LadderGenerator ladderGenerator) {
        this.lineList = ladderGenerator.generate().stream()
                .map(Line::new)
                .collect(Collectors.toList());
    }

    public List<Line> getLineList() {
        return lineList;
    }
}
