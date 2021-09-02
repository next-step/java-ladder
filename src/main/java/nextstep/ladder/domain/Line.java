package nextstep.ladder.domain;

import nextstep.ladder.util.RandomUtil;

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

    public Line(List<Point> points) {
        if (points.get(points.size() - 1).nextPoint()) {
            throw new IllegalArgumentException("올바른 사다리가 아닙니다");
        }
        this.points = points;
    }

    private void createPoint(int playersCounts) {
        points.add(Point.init(RandomUtil.generate())); // 처음 사다리 Line은 지정 된 값
        for (int i = START_INDEX; i < playersCounts - 1; i++) {
            points.add(points.get(i - 1).insert(RandomUtil.generate()));
        }
        points.add(points.get(playersCounts - 2).last());
    }

    public int search(int index) {
        Direction direction = new Direction(index);
        int point = points.get(index).move();
        return direction.move(point);
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
