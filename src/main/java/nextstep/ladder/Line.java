package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final Random random = new Random();
    private final List<Boolean> points;

    public Line(int personCount) {
        this(getPoints(personCount));
    }

    public Line(List<Boolean> points) {
        validPoints(points);
        this.points = points;
    }

    private static void validPoints(List<Boolean> points) {
        for (int i = 0; i < points.size() - 1; i++) {
            if (points.get(i) && points.get(i + 1)) {
                throw new IllegalArgumentException("잘못된 사다리입니다.");
            }
        }
    }

    private static ArrayList<Boolean> getPoints(int personCount) {
        ArrayList<Boolean> points = new ArrayList<>();
        for (int j = 0; j < personCount - 1; j++) {
            if (j == 0) {
                points.add(random.nextBoolean());
                continue;
            }
            if (points.get(j - 1)) {
                points.add(false);
                continue;
            }
            points.add(random.nextBoolean());
        }
        return points;
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
