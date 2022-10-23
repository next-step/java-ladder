package nextstep.laddar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private List<Line> lines = new ArrayList<>();

    public Ladder(int height, int count, BooleanGenerator booleanGenerator) {
        IntStream.range(0, height)
                .forEach((i) -> lines.add(new Line(count, booleanGenerator)));
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
