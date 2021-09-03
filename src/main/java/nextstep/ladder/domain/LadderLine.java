package nextstep.ladder.domain;

import nextstep.ladder.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LadderLine {
    private static final int START_INDEX = 1;
    private List<Point> points;

    public LadderLine() {
        this(0);
    }

    public LadderLine(int playersCounts) {
        this.points = new ArrayList<>();
        createBody(playersCounts);
    }

    public LadderLine(List<Point> points) {
        if (points.get(points.size() - 1).nextPoint()) {
            throw new IllegalArgumentException("올바른 사다리가 아닙니다");
        }
        this.points = points;
    }

    public static LadderLine of(int countOfPerson) {
        List<Point> points = new ArrayList<>();
        Point point = Point.init(RandomUtil.generate());
        points.add(point);

        return new LadderLine(points);
    }

    private void createBody2(int countOfPerson , List<Point> points) {
        for (int i = START_INDEX; i < countOfPerson - 1; i++) {
            points.add(points.get(i - 1).next(RandomUtil.generate()));
        }
        points.add(points.get(countOfPerson - 2).last());
    }

    private void createBody(int countOfPerson) {
        for (int i = START_INDEX; i < countOfPerson - 1; i++) {
            points.add(points.get(i - 1).next(RandomUtil.generate()));
        }
        points.add(points.get(countOfPerson - 2).last());
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
