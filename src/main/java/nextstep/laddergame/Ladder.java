package nextstep.laddergame;

import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> line;

    public Ladder(String ladderHeight, int countOfPerson) {
        this(Integer.parseInt(ladderHeight), countOfPerson);
    }

    public Ladder(int ladderHeight, int countOfPerson) {
        this(IntStream.range(0, ladderHeight).mapToObj(i -> new Line(countOfPerson)).toList());
    }

    public Ladder(List<Line> line) {
        this.line = line;
    }

    public List<Line> getLine() {
        return line;
    }
}
