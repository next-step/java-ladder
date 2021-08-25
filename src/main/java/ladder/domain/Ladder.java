package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();

    public static Ladder create(int height, int size) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.create(size));
        }
        return new Ladder(lines);
    }

    public Ladder(List<Line> lines) {
        this.lines.addAll(lines);
    }

    public List<Line> getLines() {
        return lines;
    }

    int index(int index) {
        int resultIndex = index;
        for (Line line : lines) {
            resultIndex = indexFromLine(resultIndex, line);
        }
        return resultIndex;
    }

    private int indexFromLine(int index, Line line) {
        if (index < line.size() && line.point(index)) {
            return index + 1;
        }
        if (index > 0 && line.point(index - 1)) {
            return index - 1;
        }
        return index;
    }

    @Override
    public String toString() {
        return "Ladder {" +
                "    lines = " + lines + ",\n" +
                '}';
    }
}
