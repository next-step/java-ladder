package laddergame.domain;

import laddergame.exception.CustomException;
import laddergame.strategy.LineStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Line {

    public static final String EXIST_TRUE_REPETITION = "연속된 사다리가 존재 합니다.";

    private final List<Boolean> points = new ArrayList<>();

    public Line(int widthOfLadder, LineStrategy lineStrategy) {
        initLine(widthOfLadder-1, lineStrategy);
        validateTrueRepetition(points);
    }

    private void initLine(int sizeOfPoints, LineStrategy lineStrategy) {
        for (int i = 0; i < sizeOfPoints; i++) {
            points.add(lineStrategy.create());
        }
    }

    private void validateTrueRepetition(List<Boolean> points) {
        for (int i = 1; i < points.size(); i++) {
            checkTrueRepetition(points, i);
        }
    }

    private void checkTrueRepetition(List<Boolean> points, int i) {
        if (points.get(i - 1).equals(true) && points.get(i).equals(true)) {
            throw new CustomException(EXIST_TRUE_REPETITION);
        }
    }

    public Stream<Boolean> stream() {
        return points.stream();
    }
}
