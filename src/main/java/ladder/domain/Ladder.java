package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final static int INITIAL = 0;
    private final List<Line> lines;

    private Ladder(int height, int countOfPerson) {
        lines = new ArrayList<>();
        IntStream.range(INITIAL, height)
                .forEachOrdered(number -> lines.add(Line.of(countOfPerson)));
    }

    public static Ladder of(int height, int numberOfUser) {
        return new Ladder(height, numberOfUser);
    }

    public List<Line> getLines() {
        return lines;
    }
}
