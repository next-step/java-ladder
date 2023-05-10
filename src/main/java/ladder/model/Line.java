package ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        validatePoints(points);
        this.points = points;
    }

    private void validatePoints(List<Boolean> points) {
        IntStream.range(0, points.size() - 1)
                .filter(i -> points.get(i) && points.get(i + 1))
                .findAny()
                .ifPresent(i -> {
                    throw new IllegalArgumentException("사다리 한 라인에 가로 라인이 겹칠 수 없습니다.");
                });
    }

    public static Line of(int countOfUser, BooleanGenerator booleanGenerator) {
        List<Boolean> points = new ArrayList<>();

        IntStream.range(0, countOfUser - 1)
                .forEach(i -> points.add(createNextPoint(points, i, booleanGenerator)));

        return new Line(points);
    }

    private static boolean createNextPoint(List<Boolean> points, int index, BooleanGenerator booleanGenerator) {
        if (hasPrevious(points, index)) {
            return false;
        }
        return booleanGenerator.generate();
    }

    private static boolean hasPrevious(List<Boolean> points, int index) {
        if (index <= 0) {
            return false;
        }
        return points.get(index - 1);
    }

    public int size() {
        return points.size();
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
