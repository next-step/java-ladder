package ladder.domain;

import java.util.Objects;

public class Direction {

    private static final int NOT_MOVE = 0;
    private static final int TO_LEFT = -1;
    private static final int TO_RIGHT = 1;

    private final boolean left;
    private final boolean right;


    private Direction(boolean left, boolean right){
        validateDirection(left, right);
        this.left = left;
        this.right = right;
    }

    public static Direction first(boolean right) {
        return of(false, right);
    }

    public Direction next(DirectionStrategy directionStrategy) {
        if(this.right){
            return next(false);
        }

        return next(directionStrategy.build());
    }

    public Direction next(boolean nextRight) {
        return of(this.right, nextRight);
    }

    public Direction last() {
        return of(this.right, false);
    }

    private void validateDirection(boolean left, boolean right) {
        if(left && right){
            throw new IllegalArgumentException("사다리 가로라인은 겹칠 수 없습니다.");
        }
    }

    public static Direction of(boolean left, boolean right){
        return new Direction(left, right);
    }


    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }


    public int moveIndex() {

        if(left && right){
            throw new IllegalArgumentException("사다리 가로라인은 겹칠 수 없습니다.");
        }

        if(!left && !right){
            return NOT_MOVE;
        }

        if(left){
            return TO_LEFT;
        }

        if(right){
            return TO_RIGHT;
        }

        return  NOT_MOVE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return left == direction.left &&
                right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
