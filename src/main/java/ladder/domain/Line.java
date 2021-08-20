package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {
    private final int START_INDEX_MIDDLE_LINE = 1;
    private final List<Point> points;

    private Line(int countOfPerson) {
        validate(countOfPerson);
        List<Point> points = new ArrayList<>();
        constructLine(countOfPerson, points);
        this.points = Collections.unmodifiableList(points);
    }

    public static Line from(int countOfPerson) {
        return new Line(countOfPerson);
    }

    private void validate(final int countOfPerson) {
        if (countOfPerson < 2) {
            throw new IllegalArgumentException("사람 수는 최소 2명 이상이어야 합니다.");
        }
    }

    private void constructLine(final int countOfPerson, final List<Point> points) {
        Random random = new Random();
        points.add(Point.of(false, random.nextBoolean()));
        IntStream.range(START_INDEX_MIDDLE_LINE, countOfPerson - 1)
            .forEach(i -> points.add(Point.of(isExistLeft(random, points.get(i - 1)), random.nextBoolean())));
        points.add(Point.of(random.nextBoolean(), false));
    }

    private boolean isExistLeft(final Random random, final Point point) {
        boolean isExistLeft = random.nextBoolean();
        if (point.existRight()) {
            isExistLeft = false;
        }
        return isExistLeft;
    }

    public List<Point> toList() {
        return points;
    }
}
