package nextstep.ladder.domain;

import nextstep.ladder.data.MoveDirection;
import nextstep.ladder.data.StepType;

import java.util.List;

public class Line {

    public static final int LEFT_SIDE_INDEX = 0;
    private final List<StepType> points;

    private Line(List<StepType> stepTypes) {
        validateStepStrategy(stepTypes);

        this.points = stepTypes;
    }

    private void validateStepStrategy(List<StepType> strategyResult) {
        for (int i = 1; i < strategyResult.size(); i++) {
            validateContinuedStep(strategyResult, i);
        }
    }

    private void validateContinuedStep(List<StepType> strategyResult, int currentIndex) {
        if (strategyResult.get(currentIndex - 1) == StepType.STEP && strategyResult.get(currentIndex) == StepType.STEP) {
            throw new IllegalArgumentException("올바르지 못한 LineStrategy 입니다.");
        }
    }

    public static Line of(List<StepType> stepTypes) {
        return new Line(stepTypes);
    }

    public List<StepType> toList() {
        return List.copyOf(points);
    }

    public int getDestinationFrom(int departPosition) {
        return departPosition + movePosition(departPosition);
    }

    private int movePosition(int departPosition) {
        if (isLeftSide(departPosition)) {
            return moveFromLeftSide(departPosition);
        }

        if (isRightSide(departPosition)) {
            return moveFromRightSide(departPosition);
        }

        return moveFromMiddleSide(departPosition);
    }

    private boolean isLeftSide(int currentPosition) {
        return currentPosition == LEFT_SIDE_INDEX;
    }

    private int moveFromLeftSide(int currentPosition) {
        if (canMoveToRight(currentPosition)) {
            return MoveDirection.RIGHT.getDirection();
        }

        return MoveDirection.STAY.getDirection();
    }

    private boolean isRightSide( int currentIndex) {
        return currentIndex == this.points.size();
    }

    private int moveFromRightSide(int currentIndex) {
        if (canMoveToLeft(currentIndex)) {
            return MoveDirection.LEFT.getDirection();
        }

        return MoveDirection.STAY.getDirection();
    }

    private int moveFromMiddleSide(int currentIndex) {
        if (canMoveToLeft(currentIndex)) {
            return MoveDirection.LEFT.getDirection();
        }

        if (canMoveToRight(currentIndex)) {
            return MoveDirection.RIGHT.getDirection();
        }

        return MoveDirection.STAY.getDirection();
    }

    private boolean canMoveToLeft(int currentPosition) {
        return this.points.get(currentPosition - 1) == StepType.STEP;
    }

    private boolean canMoveToRight(int currentPosition) {
        return this.points.get(currentPosition) == StepType.STEP;
    }

    public int size() {
        return this.points.size();
    }
}
