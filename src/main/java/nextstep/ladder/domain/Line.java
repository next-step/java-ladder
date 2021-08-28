package nextstep.ladder.domain;

import nextstep.ladder.util.RandomUtil;

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
        createPoint(playersCounts);
    }

    private void createPoint(int playersCounts) {
        Point init = Point.init(); // 처음 사다리 Point 무조건(false, 랜덤값)
        point.add(init);
        for (int i = START_INDEX; i< playersCounts; i++) {
            if (init.nextPoint()){
                point.add(Point.init());
            }else {
               point.add(Point.of());
            }

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
