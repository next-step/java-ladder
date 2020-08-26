package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LineRandomGenerator {
    private int participantCount;

    public LineRandomGenerator(int participantCount) {
        this.participantCount = participantCount;
    }

    public Line create() {
        List<Points> points = new ArrayList<>();

        for (int i = 0; i < participantCount; i++) {
            points.add(new Points());
        }

        return Line.create(points);
    }
}
