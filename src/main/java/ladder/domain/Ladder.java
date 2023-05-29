package ladder.domain;

import ladder.strategy.RandomLineCreateStrategy;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class  Ladder {

    private static final String HEIGHT_ERROR_MESSAGE = "사다리 높이는 0보다 커야 합니다.";

    private List<Line> lines;
    private int height;

    public Ladder(int height, int width) {
        this.lines = createLines(height, width);

        validateHeight(height);
        this.height = height;
    }

    private void validateHeight(int height) {
        if (1 > height) {
            throw new IllegalArgumentException(HEIGHT_ERROR_MESSAGE);
        }
    }

    private List<Line> createLines(int height, int width) {

        RandomLineCreateStrategy addLineStrategy = new RandomLineCreateStrategy(new Random());

        return IntStream.range(0, height)
                .mapToObj(i -> new Line(width, addLineStrategy))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(this.lines);
    }

    public int getHeight() {
        return this.height;
    }

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }
}
