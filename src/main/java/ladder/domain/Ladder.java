package ladder.domain;

import ladder.dto.ResultDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();

    public static Ladder create(int height, int size) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(size));
        }
        return new Ladder(lines);
    }

    public Ladder(List<Line> lines) {
        this.lines.addAll(lines);
    }

    public List<Line> getLines() {
        return lines;
    }

    public int matchedPoint(int index) {
        int resultIndex = index;
        for (Line line : lines) {
            if (resultIndex < line.size() && line.point(resultIndex)) {
                resultIndex += 1;
                continue;
            }
            if (resultIndex > 0 && line.point(resultIndex - 1)) {
                resultIndex -= 1;
            }
        }
        return resultIndex;
    }

    @Override
    public String toString() {
        return "Ladder {" +
                "    lines = " + lines + ",\n" +
                '}';
    }
}
