package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final static int INITIAL = 0;
    private final List<Line> lines;

    public Ladder(int height, int countOfPerson) {
        lines = new ArrayList<>();
        IntStream.range(INITIAL, height)
                .forEach( number -> lines.add(Line.of(countOfPerson)));
    }

    public List<Line> getLines() {
        return lines;
    }

    public int height() {
        return lines.size();
    }

}
