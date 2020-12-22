package ladder.domain.ladder;

public class Direction {


    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right){
        if(left & right) {
            throw new IllegalArgumentException();
        }
        this.left = left;
        this.right = right;
    }

    public static Direction first(boolean right) {
        return new Direction(false, right);
    }

    public Direction next(boolean nextRight){
        if(right && nextRight) {
            nextRight = false;
        }
        return new Direction(right, nextRight);
    }

    public Direction last(boolean right){
        return new Direction(right, false);
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }
}