package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(int count, int height, BooleanStrategy booleanStrategy) {
        List<Line> lines = new ArrayList<>();
        IntStream.range(0, height)
            .forEach(i -> lines.add(Line.of(count, booleanStrategy)));
        return new Ladder(lines);
    }

    public int result(int position) {
        int result = position;
        for (Line line : lines) {
            result = line.nextPosition(result);
        }
        return result;
    }

    public Stream<Line> stream() {
        return lines.stream();
    }
}
