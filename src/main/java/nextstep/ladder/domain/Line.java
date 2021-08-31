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

    private void createPoint(int playersCounts) {
        points.add(Point.init(RandomUtil.generate())); // 처음 사다리 Line은 지정 된 값
        for (int i = START_INDEX; i < playersCounts - 1; i++) {
            points.add(points.get(i - 1).insert(RandomUtil.generate()));
        }
        points.add(points.get(playersCounts - 2).last());
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
