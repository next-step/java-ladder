package ladder.domain;

import ladder.exception.InvalidInputException;
import ladder.exception.LadderException;
import ladder.strategy.PointStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Line {
    private static final String INVALID_HEIGHT_MESSAGE = "2 이상의 높이를 입력해주세요";
    private static final String INVALID_TRY_COUNT_MESSAGE = "사다리 생성 시도 횟수를 초과했습니다. 다시 시도해주세요.";

    private List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line of(int height) {
        if (height < 2) {
            throw new InvalidInputException(INVALID_HEIGHT_MESSAGE);
        }

        List<Boolean> points = new ArrayList<>();
        IntStream.range(0, height)
                 .forEach(point -> points.add(false));

        return new Line(points);
    }


    public static Line of(int height, Line prevLine) {
        List<Boolean> points = new ArrayList<>();
        int tryCount = 0;
        while (!valid(points)) {
            points.clear();
            checkTryCount(tryCount);
            IntStream.range(0, height)
                     .forEach(point -> points.add(PointStrategy.generate(prevLine.getPoints().get(point))));
            tryCount++;
        }

        return new Line(points);
    }

    private static boolean valid(List<Boolean> line) {
        if (line.stream().noneMatch(point -> point == true)) {
            return false;
        }
        return true;
    }

    private static void checkTryCount(int tryCount) {
        if (tryCount > 20) {
            throw new LadderException(INVALID_TRY_COUNT_MESSAGE);
        }
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}