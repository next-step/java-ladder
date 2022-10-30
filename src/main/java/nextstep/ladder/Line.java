package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final Random RANDOM = new Random();
    List<Boolean> points = new ArrayList<>();

    public Line(int countPerson) {
        for (int i = 0; i < countPerson-1; i++) {
            points.add(getPoint(i));
        }
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
