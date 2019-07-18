package ladder.domain;

import java.util.Objects;

public class LadderLineDirection {
    private final DirectionMoveState leftMoveState;
    private final DirectionMoveState rightMoveState;

    private LadderLineDirection(DirectionMoveState leftMoveState, DirectionMoveState rightMoveState) {
        this.leftMoveState = leftMoveState;
        this.rightMoveState = rightMoveState;
    }

    public static LadderLineDirection of(DirectionMoveState leftMoveState, DirectionMoveState rightMoveState) {
        if (leftMoveState.isPossible() && rightMoveState.isPossible()) {
            throw new IllegalStateException("is cannot be both move state possible");
        }

        return new LadderLineDirection(leftMoveState, rightMoveState);
    }

    public static LadderLineDirection first() {
        return of(DirectionMoveState.IMPOSSIBLE, DirectionMoveState.getRandomMoveState());
    }

    public LadderLineDirection next() {
        boolean isRightMovePossible = this.rightMoveState.isPossible();
        DirectionMoveState nextRightMoveState
                = isRightMovePossible ? DirectionMoveState.IMPOSSIBLE : DirectionMoveState.getRandomMoveState();

        return of(this.rightMoveState, nextRightMoveState);
    }

    public LadderLineDirection last() {
        return of(this.rightMoveState, DirectionMoveState.IMPOSSIBLE);
    }

    public boolean isLeftGo() {
        return leftMoveState == DirectionMoveState.POSSIBLE;
    }

    public boolean isRightGo() {
        return rightMoveState == DirectionMoveState.POSSIBLE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof LadderLineDirection))
            return false;
        LadderLineDirection that = (LadderLineDirection) o;
        return leftMoveState == that.leftMoveState &&
               rightMoveState == that.rightMoveState;
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftMoveState, rightMoveState);
    }
}
