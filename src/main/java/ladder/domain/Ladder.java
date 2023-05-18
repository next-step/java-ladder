package ladder.domain;

import ladder.strategy.RandomLineCreateStrategy;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private List<Line> lines;

    public Ladder(int height, int width) {
        createLines(height, width);
    }

    private void createLines(int height, int width) {

        RandomLineCreateStrategy addLineStrategy = new RandomLineCreateStrategy(new Random());

        this.lines = IntStream.range(0, height)
                .mapToObj(i -> new Line(width, addLineStrategy))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(this.lines);
    }
}
