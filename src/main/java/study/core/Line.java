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
            hasPreviousLine = addPoint(random, hasPreviousLine);
        }
    }

    private boolean addPoint(Random random, boolean hasPreviousLine) {
        if (hasPreviousLine) {
            points.add(false);
            return false;
        }
        boolean hasLine = random.nextBoolean();
        points.add(hasLine);
        return hasLine;
    }

    public int move(int position) {
        if (position > 0 && points.get(position - 1)) {
            return position - 1;
        }
        if (position < points.size() && points.get(position)) {
            return position + 1;
        }
        return position;
    }
}
