package ladderrefactoring.domain.ladder;

import ladderrefactoring.exception.CustomException;
import ladderrefactoring.strategy.LineStrategy;

import java.util.*;

public class Line {

    public static final String EXIST_TRUE_REPETITION = "연속된 사다리가 존재 합니다.";

    private final List<Boolean> points = new ArrayList<>();
    private int[] checkPointArr;
    private int[] movedPositionArr;

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

    public List<Boolean> points() {
        return Collections.unmodifiableList(points);
    }

    public int movePosition(int currentPosition) {
        checkPointArr = new int[]{leftPointOf(currentPosition), rightPointOf(currentPosition)};
        movedPositionArr = new int[]{moveLeft(currentPosition), moveRight(currentPosition)};

        for (int i = 0; i < checkPointArr.length; i++) {
            currentPosition = checkDirectionAndMove(currentPosition, i);
            continue;
        }

        return currentPosition;
    }

    private int checkDirectionAndMove(int currentPosition, int i) {
        if (checkPointArr[i] < 0 || checkPointArr[i] >= points.size() || !points.get(checkPointArr[i])) {
            return currentPosition;
        }

        return movedPositionArr[i];
    }

    private int moveRight(int currentPosition) {
        return currentPosition + 1;
    }

    private int moveLeft(int currentPosition) {
        return currentPosition - 1;
    }

    private int rightPointOf(int currentPosition) {
        return currentPosition;
    }

    private int leftPointOf(int currentPosition) {
        return currentPosition - 1;
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
