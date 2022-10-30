package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {
    private static final Random RANDOM = new Random();
    List<Boolean> points = new ArrayList<>();

    public Line(int countPerson) {
        IntStream.range(0, countPerson - 1)
                .forEach(i -> points.add(getPoint(i)));
    }

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public boolean isTrue(int point) {
        return point > 0 && points.get(point - 1);
    }

    public boolean addPoint(int point) {
        if (isTrue(point)) {
            return false;
        }
        return RANDOM.nextBoolean();
    }

    public boolean getPoint(int point) {
        return points.get(point);
    }
}
