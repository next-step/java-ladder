package nextstep.refactoring.ladder.concrete;

import nextstep.refactoring.ladder.engine.Line;
import nextstep.refactoring.ladder.engine.Point;
import nextstep.refactoring.ladder.engine.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LadderLine implements Line {

    private static final int MINIMUM_POINTS = 2;

    private final List<Point> points;

    private LadderLine(List<Point> points) {
        this.points = points;
    }

    public static Line of(Point... points) {
        return LadderLine.of(Arrays.asList(points));
    }

    public static Line of(List<Point> points) {
        validate(points);
        return new LadderLine(points);
    }

    public static Line init(int numberOfPoints) {
        List<Point> points = new ArrayList<>();

        LadderPoint point = LadderPoint.first();
        points.add(point);

        for (int i = 0; i < numberOfPoints - 1; i++) {
            point = point.next();
            points.add(point);
        }

        points.add(point.last());

        return new LadderLine(points);
    }

    private static void validate(List<Point> points) {
        if (points.size() < MINIMUM_POINTS) {
            throw new IllegalArgumentException("두 개 이상의 지점이 있어야 합니다.");
        }
    }

    @Override
    public Position move(Position position) {
        return points.get(position.getIndex()).traverse();
    }
}
