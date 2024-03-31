package nextstep.ladder.domain;

import nextstep.ladder.data.MoveDirection;
import nextstep.ladder.data.StepType;

import java.util.ArrayList;
import java.util.List;

public class Lines {

    public static final int LEFT_SIDE_INDEX = 0;
    private final List<Line> lines;

    private Lines(Floor floor, int countOfUsers, LineStrategy strategy) {
        this.lines = new ArrayList<>();

        for (int i = 0; i < floor.getFloor(); i++) {
            lines.add(strategy.execute(countOfUsers));
        }
    }

    public static Lines of(Floor floor, int countOfUsers, LineStrategy strategy) {
        return new Lines(floor, countOfUsers, strategy);
    }

    public List<Line> toList() {
        return List.copyOf(this.lines);
    }

    public List<Integer> gameResult(int countOfUsers) {
        List<Integer> winResult = new ArrayList<>();

        for (int i = 0; i < countOfUsers; i++) {
            int userResultPosition = getUserResult(countOfUsers, i);
            winResult.add(userResultPosition);
        }

        return winResult;
    }

    private int getUserResult(int countOfUsers, int startPosition) {
        int currentPosition = startPosition;
        for (Line line : this.lines) {
            currentPosition += movePosition(line, countOfUsers, currentPosition);
        }
        return currentPosition;
    }

    private int movePosition(Line line, int countOfUsers, int currentIndex) {
        if (isLeftSide(currentIndex)) {
            return moveFromLeftSide(line);
        }

        if (isRightSide(countOfUsers, currentIndex)) {
            return moveFromRightSide(line, currentIndex);
        }

        return moveFromMiddleSide(line, currentIndex);
    }

    private static boolean isLeftSide(int currentIndex) {
        return currentIndex == LEFT_SIDE_INDEX;
    }

    private int moveFromLeftSide(Line line) {
//        if (line.getStepTypeOfIndex(LEFT_SIDE_INDEX) == StepType.STEP) {
        if (canMoveToRight(line, LEFT_SIDE_INDEX)) {
            return MoveDirection.RIGHT.getDirection();
        }

        return MoveDirection.STAY.getDirection();
    }

    private static boolean isRightSide(int countOfUsers, int currentIndex) {
        return currentIndex == (countOfUsers - 1);
    }

    private int moveFromRightSide(Line line, int currentIndex) {
        if (canMoveToLeft(line, currentIndex)) {
            return MoveDirection.LEFT.getDirection();
        }

        return MoveDirection.STAY.getDirection();
    }

    private int moveFromMiddleSide(Line line, int currentIndex) {
        if (canMoveToLeft(line, currentIndex)) {
            return MoveDirection.LEFT.getDirection();
        }

        if (canMoveToRight(line, currentIndex)) {
            return MoveDirection.RIGHT.getDirection();
        }

        return MoveDirection.STAY.getDirection();
    }

    private static boolean canMoveToLeft(Line line, int currentIndex) {
        return line.getStepTypeOfIndex(currentIndex - 1) == StepType.STEP;
    }

    private static boolean canMoveToRight(Line line, int currentIndex) {
        return line.getStepTypeOfIndex(currentIndex) == StepType.STEP;
    }
}
