package ladder.domain;

import ladder.strategy.ConnectionStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lines {

    private final List<Line> lines = new ArrayList<>();

    public Lines(int size, int height, ConnectionStrategy connection) {
        IntStream.range(0, height)
                .forEach((i) -> lines.add(new Line(size, connection)));
    }

    public List<Line> getLines() {
        return lines;
    }

    public int nextIndex(int playerIndex) {
        int resultIndex = playerIndex;
        for (Line line : this.lines) {
            resultIndex = line.nextIndex(playerIndex);
        }
        return resultIndex;
    }
}
