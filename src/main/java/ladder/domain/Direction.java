package ladder.domain;

public class Direction {
    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right){
        this.left = left;
        this.right = right;
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


    public int moveIndex(int moveIndex) {

        if(left && right){
            throw new IllegalArgumentException(LadderGameErrorMessage.ILLEGAL_LINE_POINTS.getErrorMessage());
        }

        if(!left && !right){
            return moveIndex;
        }

        if(left){
            moveIndex--;
            return moveIndex;
        }

        if(right){
            moveIndex++;
            return moveIndex;
        }

        return  moveIndex;
    }
}
