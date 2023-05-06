package nextstep.ladder.domain;

import nextstep.ladder.support.RandomBoolean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Point> points = new ArrayList<>();
    private final int countOfMember;

    public Line(int countOfMember, RandomBoolean randomBoolean) {
        this.countOfMember = countOfMember;
        IntStream.range(0, this.countOfMember)
                 .forEachOrdered(i -> this.addPoint(i, randomBoolean.nextBoolean()));
    }

    public Line(Boolean... booleans) {
        this.countOfMember = booleans.length;
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

        if (this.canNotHaveRightPoint(beforePoint.isRight())) {
            return beforePoint.right(false);
        }

        return beforePoint.right(isPoint);
    }

    private boolean canNotHaveRightPoint(boolean isBeforeRight) {
        return countOfMember - 1 == points.size() || isBeforeRight;
    }

    public List<Point> points() {
        return Collections.unmodifiableList(this.points);
    }

    public int position(int currentPosition) {
        return currentPosition + points.get(currentPosition).move();
    }
}
