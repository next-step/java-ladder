package laddergameplay.domain.ladder;

import laddergameplay.exception.CustomException;
import laddergameplay.strategy.LineStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {

    public static final String EXIST_TRUE_REPETITION = "연속된 사다리가 존재 합니다.";

    private final List<Boolean> points = new ArrayList<>();

    public Line(int widthOfLadder, LineStrategy lineStrategy) {
        initLine(widthOfLadder, lineStrategy);
        validateTrueRepetition(points);
    }

    private void initLine(int widthOfLadder, LineStrategy lineStrategy) {
        for (int i = 0; i < widthOfLadder; i++) {
            points.add(lineStrategy.create());
        }
    }

    private void validateTrueRepetition(List<Boolean> points) {
        for (int i = 0; i < points.size()-1; i++) {
            boolean currentValue = points.get(i);
            boolean afterValue = points.get(i + 1);

            checkTrueRepetition(currentValue, afterValue);
        }
    }

    private void checkTrueRepetition(boolean beforeValue, boolean currentValue) {
        if (beforeValue && currentValue) {
            throw new CustomException(EXIST_TRUE_REPETITION);
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
