package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Line {
    private static final int START_INDEX = 1;
    private static final Random random = new Random();
    private List<Point> points;

    public Line() {
        this(0);
    }

    public Line(int playersCounts) {
        this.points = new ArrayList<>();
        createPoint(playersCounts);
    }

    private void createPoint(int playersCounts) {
        points.add(Point.init());
        for (int i = START_INDEX; i < playersCounts; i++) {
            if (points.get(i - 1).nextPoint()) { // 이전의 다음값 == 현재값이 true이면 다음 값은 무조건 false이다.
                points.add(Point.of());
            } else {
                points.add(Point.init());
            }
        }
    }

    public boolean checkPreviousPoint(boolean previousPoint) {
        if (previousPoint) {
            return false;
        }
        return random.nextBoolean();
    }

    public int size() {
        return points.size();
    }

    public Stream<Point> stream() {
        return points.stream();
    }

    @Override
    public String toString() {
        return points.toString();
    }
}
