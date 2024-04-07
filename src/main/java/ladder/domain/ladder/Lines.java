package ladder.domain.ladder;

import ladder.domain.ladder.point.PointAddStrategy;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    public Line getLine(int index) {
        return lines.get(index);
    }

    public static Lines createLines(int height, int countOfPerson, PointAddStrategy pointAddStrategy) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.createPointLine(countOfPerson, pointAddStrategy));
        }
        return new Lines(lines);
    }
}
