package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public static Ladder from(int height) {
        List<Line> lines = new ArrayList<>();
        IntStream.rangeClosed(1, height)
                .forEach(i -> lines.add(new Line()));
        return new Ladder(lines);
    }

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }


}
