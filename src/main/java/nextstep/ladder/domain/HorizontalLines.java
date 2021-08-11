package nextstep.ladder.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class HorizontalLines {

    private final List<HorizontalLine> horizontalLines;

    public HorizontalLines(final List<HorizontalLine> horizontalLines) {
        this.horizontalLines = horizontalLines;
    }

    public static HorizontalLines of(final int height, final int playerCount) {
        return Stream.generate(() -> HorizontalLine.of(playerCount))
            .limit(height)
            .collect(collectingAndThen(toList(), HorizontalLines::new));
    }

    public int size() {
        return horizontalLines.size();
    }

    public int goal(final int start) {
        return horizontalLines.stream().reduce(
            start,
            (goal, line) -> line.next(goal),
            (a, b) -> 0);
    }

    public List<HorizontalLine> getValues() {
        return Collections.unmodifiableList(horizontalLines);
    }
}
