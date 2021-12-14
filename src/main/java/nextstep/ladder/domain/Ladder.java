package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private static final int MIN_HEIGHT = 1;

    private final List<Line> lines;

    public Ladder(int height) {
        IntStream.range(MIN_HEIGHT, height)
                .forEach(line -> {
                    new Line(0);
                });
        this.lines = null;
    }

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "lines=" + lines +
                '}';
    }
}
