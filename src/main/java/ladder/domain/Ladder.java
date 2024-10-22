package ladder.domain;

import ladder.generator.Strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Ladder {
    private final LadderNumber weight;
    private final LadderNumber height;
    private final List<Line> lines = new ArrayList<>();
    private final Strategy strategy;

    public Ladder(int weight, int height, Strategy strategy) {
        this(new LadderNumber(weight), new LadderNumber(height), strategy);
        createLines();
    }

    public Ladder(LadderNumber weight, LadderNumber height, Strategy strategy) {
        this.weight = weight;
        this.height = height;
        this.strategy = strategy;
    }

    private void createLines() {
        IntStream.range(0, height.getNumber())
                .forEach(n -> this.lines.add(new Line(weight.getNumber(), strategy)));
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(height, ladder.height) && Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, lines);
    }
}
