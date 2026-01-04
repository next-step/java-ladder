package nextstep.laddergame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import nextstep.laddergame.util.RandomUtil;

public record Line(List<Boolean> points) {

    public Line(boolean... values) {
        this(IntStream.range(0, values.length).mapToObj(i -> values[i]).toList());
    }

    public Line(int countOfPerson) {
        this(lineGenerate(countOfPerson));
    }

    public Line {
        validate(points);
    }

    private static List<Boolean> lineGenerate(int countOfPerson) {
        List<Boolean> points = new ArrayList<>();
        boolean previous = false;

        for (int i = 0; i < countOfPerson; i++) {
            boolean current = lineDecider(previous);
            points.add(current);
            previous = current;
        }
        if (isAllPointsFalse(points)) {
            points.set(RandomUtil.randomIndex(points.size()), true);
        }
        return points;
    }

    private static boolean lineDecider(boolean previous) {
        if (previous) {
            return false;
        }
        return RandomUtil.halfAndHalfBoolean();
    }

    private void validate(List<Boolean> points) {
        if (isAllPointsFalse(points)) {
            throw new IllegalArgumentException("모든 라인이 false일 수 없습니다");
        }

        if (IntStream.range(1, points.size()).anyMatch(i -> points.get(i - 1) && points.get(i))) {
            throw new IllegalArgumentException("인접라인이 서로 true일수 없습니다");
        }

    }

    private static boolean isAllPointsFalse(List<Boolean> points) {
        return points.stream().noneMatch(Boolean::booleanValue);
    }

    @Override
    public String toString() {
        return "Line{" +
            "points=" + points +
            '}';
    }
}
