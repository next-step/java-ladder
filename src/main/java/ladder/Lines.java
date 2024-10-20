package ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lines {
    private List<Line> lines = new ArrayList<>();
    private LineGenerateStrategy lineGenerateStrategy;

    public Lines(List<Line> lines) {
        this(lines, new RandomLineGenerator());
    }

    public Lines(List<Line> lines, LineGenerateStrategy lineGenerateStrategy) {
        this.lines = lines;
        this.lineGenerateStrategy = lineGenerateStrategy;
    }

    public Lines(int countOfPerson, Height height) {
        this(countOfPerson, height.getValue(), new RandomLineGenerator());
    }

    public Lines(int countOfPerson, int height) {
        this(countOfPerson, height, new RandomLineGenerator());
    }

    public Lines(int countOfPerson, int height, LineGenerateStrategy lineGenerateStrategy) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(countOfPerson, lineGenerateStrategy));
        }
    }

    public List<Line> getLines() {
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lines lines1 = (Lines) o;
        return Objects.equals(lines, lines1.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lines);
    }

    @Override
    public String toString() {
        return "Lines{" +
                "lines=" + lines +
                '}';
    }
}
