package ladder.domain;


public class Position {

    private static final int ONE = 1;
    private static final boolean FALSE = false;

    private int position;
    private boolean left;
    private boolean right;

    public Position(int position, boolean left, boolean right){
        this.position = position;
        this.left = left;
        this.right = right;
    }

    boolean isOverlapped(boolean newPoint) {
        return this.right == newPoint;
    }

    boolean isMovableToLeft() {
        return this.left;
    }

    int moveLeft() {
        return this.position - ONE;
    }

    boolean isMovableToRight() {
        return this.right;
    }

    int moveRight() {
        return this.position  + ONE;
    }

    static Position generateFirstPosition(int currPosition, boolean first) {
        return new Position(currPosition, FALSE, first);
    }

    static Position generateLastPosition(int currPosition, Position prev) {
        return new Position(currPosition, prev.right, FALSE);
    }

    static Position generateNewPosition(int currPosition, Position prev, boolean newPoint) {
        return new Position(currPosition, prev.right, newPoint);
    }

    @Override
    public String toString() {
        if(this.right) {
            return "-----";
        }

        return "     ";
    }
}
