package ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int height, int count, PointStrategy strategy) {
        List<Line> ladder = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladder.add(new Line(count, strategy));
        }
        this.lines = ladder;
    }

    public int move(int index) {
        for (Line line : lines) {
            index = line.move(index);
        }
        return index;
    }

    public List<Line> lines() {
        return List.copyOf(lines);
    }
}
