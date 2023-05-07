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

    public static Line of(int countOfUser, LineGenerator lineGenerator) {
        List<Boolean> points = new ArrayList<>();

        IntStream.range(0, countOfUser - 1)
                .forEach(i -> {
                    boolean point = lineGenerator.generate(hasPrevious(points, i));
                    points.add(point);
                });

        return new Line(points);
    }

    public int size() {
        return points.size();
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }

    private static boolean hasPrevious(List<Boolean> points, int index) {
        if (index <= 0) {
            return false;
        }
        return points.get(index - 1);
    }

    private void validatePoints(List<Boolean> points) {
        IntStream.range(0, points.size() - 1)
                .filter(i -> points.get(i) && points.get(i + 1))
                .findAny()
                .ifPresent(i -> {
                    throw new IllegalArgumentException("사다리 한 라인에 가로 라인이 겹칠 수 없습니다.");
                });
    }
}
