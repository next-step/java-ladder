package nextstep.ladder.domain.line;

import nextstep.ladder.strategy.LiningStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lines {
    private final List<Line> lines;

    public Lines(LiningStrategy liningStrategy, int playerCount, int ladderHeight) {
        lines = Stream.generate(() -> new Line(liningStrategy, playerCount))
                .limit(ladderHeight)
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
