package ladder.domain;

import ladder.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final int FIRST_POINT = 0;

    private final List<Boolean> points;

    public Line(int countOfPlayers) {
        this.points = init(countOfPlayers);
    }

    public Line(boolean... points) {
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            result.add(points[i]);
        }
        this.points = result;
    }

    private List<Boolean> init(int countOfPlayers) {
        List<Boolean> points = new ArrayList<>();
        for (int i = 0; i < countOfPlayers - 1; i++) {
            addPoints(points, i);
        }
        points.add(false); // 마지막 점은 무조건 false
        return points;
    }

    private void addPoints(List<Boolean> points, int point) {
        if (point == FIRST_POINT) {
            points.add(RandomGenerator.generate());
            return;
        }

        if (points.get(point - 1) == true) {
            points.add(false);
            return;
        }

        points.add(RandomGenerator.generate());
    }

    public int numberOfPoints() {
        return points.size();
    }

    public boolean hasRightLine(int point) {
        return points.get(point);
    }
}
