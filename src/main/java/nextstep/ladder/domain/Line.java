package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Line {

    private static final Random RANDOM = new Random();

    private final List<Point> points;

    public Line(int countOfPerson) {
        this.points = new ArrayList<>();
        for (int i = 0; i < countOfPerson - 1; i++) {
            points.add(createRandomPoint(i));
        }
    }

    public Line(List<Point> points) {
        this.points = points;
    }

    private Point createRandomPoint(int index) {
        return canDrawRight(index) ?
            new Point(RANDOM.nextBoolean()) : Point.withoutRight(); // Point에 factory method 추가
    }

    private boolean canDrawRight(int index) {
        if (index == 0) {
            return true;
        }
        return !points.get(index - 1).hasRight();
    }

    public List<Point> points() {
        return Collections.unmodifiableList(points);
    }

    public int move(int index) {
        if (hasRightLine(index)) {
            return index + 1;
        }
        if (hasLeftLine(index)) {
            return index - 1;
        }
        return index;
    }

    private boolean hasRightLine(int index) {
        return index < points.size() && points.get(index).hasRight();
    }

    private boolean hasLeftLine(int index) {
        return index > 0 && points.get(index - 1).hasRight();
    }
}