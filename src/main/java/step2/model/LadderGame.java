package step2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LadderGame {

    private final List<Line> lines;

    public LadderGame(List<Line> lines) {
        this.lines = lines;
    }

    public LadderGame(final int lineHeight, final int playersCount) {
        List<Line> result = new ArrayList<>();

        IntStream.range(0, lineHeight)
                .forEach(line -> result.add(new Line(playersCount)));

        this.lines = result;
    }

    public int getLineSize() {
        return this.lines.size();
    }
}
