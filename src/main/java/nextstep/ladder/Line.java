package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {
    private static final Random RANDOM = new Random();
    List<Boolean> points = new ArrayList<>();

    public Line(final int countPerson) {
        IntStream.range(0, countPerson - 1)
                .forEach(i -> points.add(addPoint(i)));
    }

    public Line(List<Boolean> points) {
        this.points = points;
    }

    boolean addPoint(int point) {
        if (isCondition(point)) {
            return false;
        }
        return RANDOM.nextBoolean();
    }

    private boolean isCondition(int point) {
        return point > 0 && points.get(point - 1);
    }

    public boolean getPoint(int point) {
        return points.get(point);
    }
}
