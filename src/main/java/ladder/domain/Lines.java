package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lines {

    private final Height height;

    private final List<Line> lines;

    private Lines(Width width, Height height) {
        this.height = height;
        lines = initLines(width, height);
    }

    public static Lines create(Width width, Height height) {
        return new Lines(width, height);
    }

    private List<Line> initLines(Width width, Height height) {
        final List<Line> lines = new ArrayList<>(height.getLength());
        for (int i = 0; i < height.getLength(); i++) {
            lines.add(Line.createWithWidth(width));
        }
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lines lines1 = (Lines) o;
        return Objects.equals(height, lines1.height) && Objects.equals(lines, lines1.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, lines);
    }
}
