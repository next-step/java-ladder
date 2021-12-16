package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private static final int START_INDEX = 0;
    private final List<Line> lines;

    public Ladder(int LadderSize, int playerSize) {
        lines = new ArrayList<>();
        IntStream.range(START_INDEX, LadderSize)
                .forEach(x -> lines.add(new Line(playerSize)));
    }

    public static Ladder of(Height height, Players players) {
        return new Ladder(height.getSize(), players.count());
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
