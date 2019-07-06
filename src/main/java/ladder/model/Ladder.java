package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();

    public Ladder(int height, int numberOfParticipants) {
        for (int i = 0; i < height; i++) {
            final Line line = new Line(numberOfParticipants);
            lines.add(line);
        }
    }
}
