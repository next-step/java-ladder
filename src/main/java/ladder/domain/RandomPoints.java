package ladder.domain;

import ladder.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RandomPoints implements PointsStrategy {
    private static final int FIRST_POINT = 0;

    private int number;

    public RandomPoints(int number) {
        this.number = number;
    }

    @Override
    public List<Boolean> points() {
        List<Boolean> points = new ArrayList<>();
        IntStream.range(0, number - 1).forEach(i -> addPoints(points, i));
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
}
