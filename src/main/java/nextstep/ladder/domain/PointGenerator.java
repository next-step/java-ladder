package nextstep.ladder.domain;

import nextstep.ladder.util.RandomUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class PointGenerator {

    private static final int START_IDX = 1;

    private List<Point> points;

    protected PointGenerator(List<Boolean> points) {
        this.points = points.stream()
                .map(Point::new)
                .collect(Collectors.toUnmodifiableList());
    }

    protected PointGenerator() {
        this(new ArrayList<>());
    }

    public List<Point> generate(Supplier<List<Boolean>> points) {
        return this.points = points.get()
                .stream()
                .map(Point::new)
                .collect(Collectors.toList());
    }

    public List<Point> generate(int countOfPerson) {
        this.points.add(createFirstPoint(RandomUtil::getRandomBoolean));
        for (int idx = START_IDX; idx < countOfPerson - 1; idx++) {
            this.points.add(createPoint(idx, RandomUtil::getRandomBoolean));
        }
        this.points.add(new Point(false));
        return Collections.unmodifiableList(this.points);
    }

    private Point createFirstPoint(ConnectStrategy connectStrategy) {
        return new Point(connectStrategy.connectable());
    }

    private Point createPoint(int idx, ConnectStrategy connectStrategy) {
        if (!connectStrategy.connectable()) {
            return new Point(false);
        }
        return new Point(leftPointConnectable(idx));
    }

    private boolean leftPointConnectable(int idx) {
        return this.points.get(idx - 1).connectable();
    }
}