package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private int height;
    private final List<Line> lines = new ArrayList<>();

    public Ladder(int height) {
        this(height, IntStream.range(0, height).mapToObj(Line::new).collect(Collectors.toList()));
    }

    public Ladder(int height, List<Line> lines) {
        this.height = height;
        this.lines.addAll(lines);
    }
}
