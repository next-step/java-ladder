package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder implements Iterable<Line> {

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

    @Override
    public Iterator<Line> iterator() {
        return lines.iterator();
    }
}
