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
        points.add(Point.first()); // 처음 사다리 Line은 지정 된 값
        for (int i = START_INDEX; i < playersCounts; i++) {
            if (i == playersCounts-1) { // 마지막 Line인 경우

            }
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

    public int search(int index) {
        Point point = points.get(index);
        return point.move();
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
