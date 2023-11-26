package step2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LadderGame {

    private final List<Line> lines;

    public LadderGame(final int lineHeight, final int playersCount) {
        List<Line> result = new ArrayList<>();

        IntStream.range(0, lineHeight)
                .forEach(line -> result.add(new Line(playersCount, new PointRandomStrategy())));

        this.lines = result;
    }

    public List<Line> getLines() {
        return this.lines;
    }
}
