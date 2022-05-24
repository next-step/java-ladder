package nextstep.ladder.model.ladder;

import nextstep.ladder.exception.LadderLengthException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

import static nextstep.ladder.model.ConstantNumber.ONE;
import static nextstep.ladder.model.ConstantNumber.TWO;
import static nextstep.ladder.util.LadderPointGenerator.generatePoint;

public final class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    private static void isMinimum(int countOfPeople) {
        Optional.of(countOfPeople)
                .filter(count -> TWO.getValue() <= count)
                .orElseThrow(LadderLengthException::new);
    }

    public int move(int column) {
        return this.points.get(column).move();
    }

    public static Line init(List<Point> points) {
        isMinimum(points.size());
        return new Line(points);
    }

    public static Line init(int countOfPeople) {
        isMinimum(countOfPeople);
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points);
        point = initBody(countOfPeople, points, point);
        initLast(points, point);
        return new Line(points);
    }

    private static void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    private static Point initBody(int countOfPeople, List<Point> points, Point point) {
        AtomicReference<Point> pointAtomic = new AtomicReference<>(point);
        IntStream.range(ONE.getValue(), Math.subtractExact(countOfPeople, ONE.getValue()))
                .forEach(i -> points.add(pointAtomic.updateAndGet(Point::next)));

        return pointAtomic.get();
    }

    private static Point initFirst(List<Point> points) {
        Point point = Point.first(generatePoint());
        points.add(point);

        return point;
    }

    public List<Point> points() {
        return Collections.unmodifiableList(this.points);
    }

    public int size() {
        return this.points.size();
    }
}
