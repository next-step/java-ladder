package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import nextstep.ladder.domain.common.Point;
import nextstep.ladder.domain.exception.InvalidCreateHorizontalLineException;

public class HorizontalLine {

    private final List<Point> points;

    private HorizontalLine(final List<Point> points) {
        createValidation(points);
        this.points = points;
    }

    public static HorizontalLine of(final List<Point> points) {
        return new HorizontalLine(points);
    }

    public static HorizontalLine of(final int playerCount) {
        final List<Point> points = new ArrayList<>();
        points.add(Point.first());
        for (int i = 0; i < playerCount - 2; i++) {
            points.add(points.get(i).next());
        }
        points.add(points.get(playerCount - 2).last());

        return new HorizontalLine(points);
    }

    private void createValidation(final List<Point> points) {
        if (!points.get(0).isPossibleFirst()) {
            throw new InvalidCreateHorizontalLineException();
        }

        if (!points.get(points.size() - 1).isPossibleLast()) {
            throw new InvalidCreateHorizontalLineException();
        }

        IntStream.range(1, points.size() - 1)
            .filter(i -> !points.get(i).isPossibleNext(points.get(i + 1)))
            .findAny()
            .ifPresent(e -> {
                throw new InvalidCreateHorizontalLineException();
            });
    }

    public int move(final int index) {
        return points.get(index).move();
    }

    public int size() {
        return points.size();
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
