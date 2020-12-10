package ladder.domain;

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
}
