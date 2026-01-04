package nextstep.laddergame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {

    private final List<Boolean> points;

    public Line(boolean... values) {
        this(IntStream.range(0, values.length).mapToObj(i -> values[i]).toList());
    }

    public Line(int countOfPerson) {
        this(lineGenerate(countOfPerson));
    }

    public Line(List<Boolean> points) {
        validate(points);
        this.points = points;
    }

    private static List<Boolean> lineGenerate(int countOfPerson) {
        List<Boolean> points = new ArrayList<>();
        boolean previous = false;

        for (int i = 0; i < countOfPerson; i++) {
            boolean current = isLineTrue(previous);
            points.add(current);
            previous = current;
        }
        if (checkAllFalse(points)) {
            return lineGenerate(countOfPerson);
        }
        return points;
    }

    private static boolean checkAllFalse(List<Boolean> points) {
        return points.stream().noneMatch(point -> point == true);
    }

    private static boolean isLineTrue(boolean previous) {
        if (previous) {
            return false;
        }
        return new Random().nextBoolean();
    }

    public List<Boolean> getPoints() {
        return points;
    }

    private void validate(List<Boolean> points) {
        if (points.stream().noneMatch(point -> point == true)) {
            throw new IllegalArgumentException("모든 라인이 false일 수 없습니다");
        }

        if (IntStream.range(1, points.size()).anyMatch(i -> points.get(i - 1) && points.get(i))) {
            throw new IllegalArgumentException("인접라인이 서로 true일수 없습니다");
        }

    }

    @Override
    public String toString() {
        return "Line{" +
            "points=" + points +
            '}';
    }
}
