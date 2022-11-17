package ladder.domain;

import ladder.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final Players players;
    private final List<Line> lines = new ArrayList<>();
    private final Results results;

    public Ladder(int size, int height, Players players, Results results) {
        IntStream.range(0, height)
                .forEach((i) -> lines.add(new Line(size, new RandomUtil())));
        this.players = players;
        this.results = results;
    }

    public List<Line> lines() {
        return lines;
    }

    public List<String> names() {
        return this.players.names();
    }

    public int findResult(int index) {
        for (Line line : lines) {
            Point point = line.getPoints().get(index);
            if (point.getCurrent()) {
                index++;
            } else if (point.getLeft()) {
                index--;
            }
        }
        return index;
    }
}
