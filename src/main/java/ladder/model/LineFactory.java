package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public enum LineFactory {
    INSTANCE;

    public Line generateRandomLine(int countOfUser) {
        List<Boolean> points = new ArrayList<>();
        Random random = new Random();
        boolean previousPoint = false;

        for (int i = 0; i < countOfUser; ++i) {
            boolean currentPoint = getCurrentPoint(previousPoint, random.nextBoolean(), i == countOfUser - 1);
            previousPoint = currentPoint;
            points.add(currentPoint);
        }

        return new Line(points);
    }

    private boolean getCurrentPoint(boolean previousPoint, boolean point, boolean isLastIndex) {
        if (isLastIndex) {
            return false;
        }

        if (previousPoint && point) {
            return false;
        }

        return point;
    }
}
