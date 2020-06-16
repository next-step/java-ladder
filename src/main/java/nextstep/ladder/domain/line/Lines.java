package nextstep.ladder.domain.line;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lines {
    private List<Line> lines;

    public Lines(int playerCount, int ladderHeight) {
        lines = Stream.generate(() -> new Line(playerCount))
                .limit(ladderHeight)
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
