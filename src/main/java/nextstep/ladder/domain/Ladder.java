package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final int height;
    private final List<Line> lines = new ArrayList<>();

    public Ladder(int height, int countOfPerson) {
        this(height, IntStream.range(0, height)
                .mapToObj((i) -> new Line(countOfPerson))
                .collect(Collectors.toList()));
    }

    public Ladder(int height, List<Line> lines) {
        this.height = height;
        this.lines.addAll(lines);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int getHeight() {
        return height;
    }
}
