package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final int FIRST_POINT = 0;

    private final List<Boolean> points;

    public Line(int countOfPlayers) {
        this.points = init(countOfPlayers, new Random());
    }

    public Line(boolean... points) {
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            result.add(points[i]);
        }
        this.points = result;
    }

    private List<Boolean> init(int countOfPlayers, Random random) {
        List<Boolean> points = new ArrayList<>();
        for (int i = 0; i < countOfPlayers - 1; i++) {
            if (hasPrevPointTrue(points, i)) {
                points.add(false);
                continue;
            }
            points.add(random.nextBoolean());
        }
        points.add(false); // 마지막 점은 무조건 false
        return points;
    }

    private boolean hasPrevPointTrue(List<Boolean> points, int point) {
        if (point == FIRST_POINT) {
            return false;
        }
        return points.get(point - 1);
    }

    public int numberOfPoints() {
        return points.size();
    }

    public boolean hasRightLine(int point) {
        return points.get(point);
    }
}
