package nextstep.domain;

import nextstep.strategy.LineStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private static final int MINIMUM_NUMBER_OF_PEOPLE = 2;
    private List<Point> points = new ArrayList<>();
    private LineStrategy lineStrategy;

    public Line(int countPerson, LineStrategy lineStrategy) {
        if (countPerson < MINIMUM_NUMBER_OF_PEOPLE) {
            throw new IllegalArgumentException("최소 2명 이상이 필요하다.");
        }
        this.lineStrategy = lineStrategy;

        points = of(countPerson, lineStrategy);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public List<Point> of(int count, LineStrategy lineStrategy) {
        points.add(Point.init(false));

        for (int point = 1; point < count - 1; point++) {
            points.add(points.get(point - 1).insert(lineStrategy.generate()));
        }
        points.add(points.get(count - 2).last());

        return Collections.unmodifiableList(points);
    }

    public int search(int idx) {
        Direction direction = new Direction(idx);
        int point = points.get(idx).move();
        return direction.move(point);
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}
