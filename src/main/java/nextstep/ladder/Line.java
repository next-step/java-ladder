package nextstep.ladder;

import nextstep.ladder.random.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

import static nextstep.ladder.Point.HAS_LINE;
import static nextstep.ladder.Point.NO_LINE;

public class Line {
    private static final String VERTICAL = "|";

    private List<Point> points = new ArrayList<>();

    public Line(int size) {
        validate(size);
        generatePoints(size);
    }

    private void generatePoints(int size) {
        Point before = NO_LINE;
        for (int i = 0; i < size; i++) {
            before = generatePoint(before);
            points.add(before);
        }
    }

    public Point generatePoint(Point before) {
        if (HAS_LINE.equals(before)) {
            return NO_LINE;
        }

        return Point.of(RandomGenerator.generate());
    }

    private void validate(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("사다리 길이는 0보다 작을 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(VERTICAL);
        for (Point point : points) {
            sb.append(point.toString());
            sb.append(VERTICAL);
        }
        return sb.toString();
    }
}
