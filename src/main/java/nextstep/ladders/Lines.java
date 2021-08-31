package nextstep.ladders;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lines {

    private final List<Line> lines;

    public Lines(final List<Line> lines) {
        this.lines = lines;
    }

    public Lines(final Generator generator, final int height, final int numberOfPeople) {
        this(Line.toList(generator, height, numberOfPeople));
    }

    public int move(int index) {
        for (Line line : lines) {
            index = line.move(index);
        }
        return index;
    }

    public List<Line> elements() {
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
        return Objects.hash(lines);
    }
}
