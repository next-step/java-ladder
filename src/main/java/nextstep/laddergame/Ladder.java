package nextstep.laddergame;

import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> line;

    public Ladder(int ladderHeight) {
        this(IntStream.range(0, ladderHeight).mapToObj(Line::new).toList());
    }

    public Ladder(List<Line> line) {
        this.line = line;
    }

    public List<Line> getLine() {
        return line;
    }
}
