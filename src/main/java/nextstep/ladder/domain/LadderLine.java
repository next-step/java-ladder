package nextstep.ladder.domain;

import nextstep.ladder.util.pointsgenerator.HalfRandomPointsGenerator;
import nextstep.ladder.util.pointsgenerator.PointsGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class LadderLine {
    private final List<Point> points;

    private LadderLine(int sizeOfPerson, PointsGenerator pointsGenerator, Function<Point, Point> nextPointFactory) {
        this.points = new ArrayList<>();
        Point point = initFirst(pointsGenerator);
        point = initBody(sizeOfPerson, point, nextPointFactory);
        initLast(point);
    }

    public static LadderLine init(int sizeOfPerson) {
        return new LadderLine(sizeOfPerson, HalfRandomPointsGenerator.getInstance(), Point::next);
    }

    public static LadderLine init(int sizeOfPerson, PointsGenerator pointsGenerator) {
        return new LadderLine(sizeOfPerson, pointsGenerator, p -> p.next(pointsGenerator.generatePoint()));
    }

    private Point initFirst(PointsGenerator pointsGenerator) {
        Point first = Point.first(pointsGenerator.generatePoint());
        this.points.add(first);
        return first;
    }

    private Point initBody(int sizeOfPerson, Point first, Function<Point, Point> nextPointFactory) {
        Point nextPoint = first;
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            nextPoint = nextPointFactory.apply(nextPoint);
            points.add(nextPoint);
        }
        return nextPoint;
    }

    private void initLast(Point point) {
        Point last = point.last();
        points.add(last);
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public void pointsForEach(Consumer<Point> consumer) {
        points.forEach(consumer);
    }

    public int size() {
        return points.size();
    }

    @Override
    public String toString() {
        return "LadderLine{" +
                "points=" + points +
                '}';
    }
}
