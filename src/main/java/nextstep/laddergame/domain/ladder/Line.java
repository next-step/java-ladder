package nextstep.laddergame.domain.ladder;

import java.util.List;
import java.util.stream.IntStream;
import nextstep.laddergame.domain.linegenerator.LineGenerator;
import nextstep.laddergame.domain.linegenerator.RandomLineGenerator;

public record Line(List<Boolean> points) {

    public Line(boolean... values) {
        this(IntStream.range(0, values.length).mapToObj(i -> values[i]).toList());
    }

    public Line(LineGenerator lineGenerator) {
        this(lineGenerator.lineDraw());
    }

    public Line(int countOfPerson) {
        this(new RandomLineGenerator(countOfPerson).lineDraw());
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

    public static boolean isAllPointsFalse(List<Boolean> points) {
        return points.stream().noneMatch(Boolean::booleanValue);
    }

    public int nextPosition(int position) {
        if (isRightConnection(position)) {
            return position + 1;
        }
        if (isLeftConnection(position)) {
            return position - 1;
        }
        return position;
    }

    private boolean isRightConnection(int line) {
        if (endOfRight(line)) {
            return false;
        }

        return points.get(line);
    }

    private boolean isLeftConnection(int line) {
        if (endOfLeft(line)) {
            return false;
        }
        return points.get(line - 1);
    }

    private static boolean endOfLeft(int line) {
        return line < 1;
    }

    private boolean endOfRight(int line) {
        return line >= points.size() - 1;
    }

    public int size() {
        return points.size();
    }

    @Override
    public String toString() {
        return "Line{" +
            "points=" + points +
            '}';
    }
}
