package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {

    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines of(int height, int playerCount) {
        List<Line> lines = IntStream.range(0, height)
            .mapToObj(i -> Line.of(playerCount))
            .collect(Collectors.toList());

        return new Lines(lines);
    }

    public int size() {
        return lines.size();
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
