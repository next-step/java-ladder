package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Ladder implements Iterable<Line> {
    private final List<Line> lines;

    private Ladder(final List<Line> lines) {
        if (lines == null) {
            throw new IllegalArgumentException("'lines' must not be null");
        }
        this.lines = new ArrayList<>(lines);
    }

    public static Ladder from(final List<Line> lines) {
        return new Ladder(lines);
    }

    public Stream<Line> stream() {
        return lines.stream();
    }

    @Override
    public Iterator<Line> iterator() {
        return lines.iterator();
    }

    @Override
    public void forEach(final Consumer<? super Line> action) {
        lines.forEach(action);
    }

    @Override
    public Spliterator<Line> spliterator() {
        return lines.spliterator();
    }
}
