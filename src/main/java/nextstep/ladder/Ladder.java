package nextstep.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private List<Line> lines = new ArrayList<>();
    private int lineCount;

    private Ladder() {
    }

    public Ladder(int height, int lineCount, BooleanFunction booleanFunction) {
        this.lines = IntStream.range(0, height)
                .mapToObj(i -> new Line(lineCount, booleanFunction))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
