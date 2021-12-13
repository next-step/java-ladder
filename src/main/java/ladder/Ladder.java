package ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BooleanSupplier;

public class Ladder  {
    private final List<Line> lines;

    public Ladder(int width, int height) {
        this(generateLine(width, height, new RandomStrategy()));
    }

    public Ladder(int width, int height, BooleanSupplier createFactor) {
        this(generateLine(width, height, createFactor));
    }

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public int singleResult(int currIndex) {
        int result = currIndex;

        for (Line line : lines) {
            result = line.move(result);
        }

        return result;
    }

    public List<Line> getLines() {
        return lines;
    }

    private static List<Line> generateLine(int width, int height, BooleanSupplier createFactor) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(new Line(width, createFactor));
        }

        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
