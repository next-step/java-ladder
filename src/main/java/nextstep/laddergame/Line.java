package nextstep.laddergame;

import java.util.List;
import java.util.stream.IntStream;

public record Line(List<Boolean> points) {

    public Line(boolean... values) {
        this(IntStream.range(0, values.length).mapToObj(i -> values[i]).toList());
    }

    public Line(int countOfPerson, LineGenerator lineGenerator) {
        this(lineGenerator.lineDraw(countOfPerson));
    }

    public Line(int countOfPerson) {
        this(new RandomLineGenerator().lineDraw(countOfPerson));
    }

    public Line {
        validate(points);
    }

    private void validate(List<Boolean> points) {
        if (isAllPointsFalse(points)) {
            throw new IllegalArgumentException("모든 라인이 false일 수 없습니다");
        }

        if (IntStream.range(1, points.size()).anyMatch(i -> points.get(i - 1) && points.get(i))) {
            throw new IllegalArgumentException("인접라인이 서로 true일수 없습니다");
        }

    }

    static boolean isAllPointsFalse(List<Boolean> points) {
        return points.stream().noneMatch(Boolean::booleanValue);
    }

    @Override
    public String toString() {
        return "Line{" +
            "points=" + points +
            '}';
    }
}
