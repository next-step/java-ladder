package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();
    private final Height height;

    public Ladder(int directionCount, int height, DirectionGenerator directionGenerator) {
        this.height = new Height(height);
        create(directionCount, directionGenerator);
    }

    private void create(int directionCount, DirectionGenerator directionGenerator) {
        for (int i = 0; i < height.getHeight(); i++) {
            lines.add(new Line(directionCount, directionGenerator));
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
