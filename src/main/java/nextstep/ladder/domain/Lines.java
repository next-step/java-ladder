package nextstep.ladder.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Lines {

    private final List<Line> lines;

    public Lines(final List<Line> lines) {
        this.lines = lines;
    }

    public static Lines of(final int height, final int playerCount) {
        return Stream.generate(() -> Line.of(playerCount))
            .limit(height)
            .collect(collectingAndThen(toList(), Lines::new));
    }

    public int size() {
        return lines.size();
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
