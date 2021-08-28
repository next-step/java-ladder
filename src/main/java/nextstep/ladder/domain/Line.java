package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Line {
    private static final int START_INDEX = 1;
    private static final Random random = new Random();
    private List<Boolean> points;
    private List<Point> point;

    public Line() {
        this(0);
    }

    public Line(int playersCounts) {
        this.points = new ArrayList<>();
        create(playersCounts);
    }

    private void create() {
        Point point = new Point(random.nextBoolean()); // 사다리 게임 생성 (첫번째는 false로 시작)
        if (point.previousPoint()) {
            new Point(random.nextBoolean());
        }else {
            new Point(point.previousPoint(), random.nextBoolean());
        }
    }

    private void create(int playersCount) {
        points.add(false);
        for (int i = START_INDEX; i < playersCount; i++) {
            points.add(checkPreviousPoint(points.get(i - 1)));
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

    public Stream<Boolean> stream() {
        return points.stream();
    }

    @Override
    public String toString() {
        return points.toString();
    }
}
