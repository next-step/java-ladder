package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {

    private static final Random random = new Random();

    private final List<Boolean> points = new ArrayList<>();

    public Line(int countOfUser) {
        IntStream.range(0, countOfUser-1)
            .forEach(index -> points.add(setPoint(index)));
    }

    public List<Boolean> getPoints() {
        return points;
    }

    private boolean setPoint(int index) {
        boolean point = random.nextBoolean();

        if (index > 0) {
            point = validPoint(point, points.get(index - 1));
        }
        return point;
    }

    private boolean validPoint(boolean currentPoint, boolean beforePoint) {

        if (currentPoint && beforePoint) {
            return false;
        }
        return currentPoint;
    }
}

