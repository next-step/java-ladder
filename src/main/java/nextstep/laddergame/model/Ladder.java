package nextstep.laddergame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();

    public Ladder(int countOfPerson, int height) {
        IntStream.range(0, height)
                 .forEach(index -> lines.add(new Line(countOfPerson)));
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public void moveDown(Position position) {
        lines.forEach(line -> line.moveSide(position));
    }
}
