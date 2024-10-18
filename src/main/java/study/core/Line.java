package study.core;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public void createPoints(int playerCount) {
        Random random = new Random();
        boolean hasPreviousLine = false;
        for (int i = 0; i < playerCount - 1; i++) {
            if (hasPreviousLine) {
                points.add(false);
                hasPreviousLine = false;
                continue;
            }
            boolean hasLine = random.nextBoolean();
            points.add(hasLine);
            hasPreviousLine = hasLine;
        }
    }
}
