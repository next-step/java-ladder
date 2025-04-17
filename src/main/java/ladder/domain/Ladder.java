package ladder.domain;

import ladder.service.PointGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();

    public Ladder(int countOfPerson, LadderHeight height, PointGenerator pointGenerator) {
        for (int i = 0; i < height.getHeight(); i++) {
            Line line = new Line(countOfPerson, pointGenerator);
            this.lines.add(line);
        }
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }
}
