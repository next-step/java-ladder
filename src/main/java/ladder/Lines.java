package ladder;

import ladder.view.Names;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lines {
    private List<Line> lines = new ArrayList<>();

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public Lines(Names names, Height height, LineGenerateStrategy lineGenerateStrategy) {
        this(names.getNames().size(), height.getValue(), lineGenerateStrategy);
    }

    public Lines(int countOfPerson, int height, LineGenerateStrategy lineGenerateStrategy) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(countOfPerson, lineGenerateStrategy));
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
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
