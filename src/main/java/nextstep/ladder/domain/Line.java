package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Line {
    private static final int START_INDEX = 1;
    private List<Point> points;

    public Line() {
        this(0);
    }

    public Line(int playersCounts) {
        this.points = new ArrayList<>();
        createPoint(playersCounts);
    }

    private void createPoint(int playersCounts) {
        points.add(Point.random()); // 처음에는 (false , 랜덤) 주입
        for (int i = START_INDEX; i < playersCounts; i++) {
            points.add(checkPreviousPoint(points.get(i - 1).nextPoint()));
        }
    }

    public Point checkPreviousPoint(boolean nextPointOfPrevious) {
        //현재값이 true 이면 (true ,false) 주입
        if (nextPointOfPrevious) {
            return Point.of();
        }
        return Point.random(); // false 면 (false , 랜덤) 주입
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
