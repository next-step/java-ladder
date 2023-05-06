package nextstep.ladder.domain;

import nextstep.ladder.support.RandomBoolean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Point> points = new ArrayList<>();

    public Line(int countOfMember, RandomBoolean randomBoolean) {
        IntStream.range(0, countOfMember - 1)
                 .forEachOrdered(i -> this.addPoint(i, randomBoolean.nextBoolean()));
    }

    public Line(Boolean... booleans) {
        IntStream.range(0, booleans.length)
                 .forEachOrdered(i -> this.addPoint(i, booleans[i]));
    }

    private void addPoint(int index, boolean isPoint) {
        points.add(getPoint(index, isPoint));
    }

    private Point getPoint(int index, boolean isPoint) {
        if (index == 0) {
            return new Point(false, isPoint);
        }

        Point beforePoint = points.get(index - 1);

        if (beforePoint.isRight()) {
            return beforePoint.right(false);
        }

        return beforePoint.right(isPoint);
    }

    public List<Point> points() {
        return Collections.unmodifiableList(this.points);
    }

    public int position(int currentPosition) {
        return currentPosition + points.get(currentPosition).move();
    }
}
