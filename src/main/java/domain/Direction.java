package domain;

public enum Direction {
    LEFT(true, false),
    RIGHT(false, true),
    FORWARD(false ,false);

    private final boolean left;
    private final boolean right;

    Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException();
        }

        this.left = left;
        this.right = right;
        //System.out.println(this);
    }

    public boolean isRight() {
        return RIGHT.equals(this);
        //return this.right;
    }

    public boolean isLeft() {
        return LEFT.equals(this);
        //return this.left;
    }

    public boolean isForward() {
        return FORWARD.equals(this);
    }

    public Direction next(boolean nextRight) {
        if(nextRight) {
            return RIGHT;
        }
        return FORWARD;
        //return of(this.right, nextRight);
    }

    public Direction next(LineStrategy ladderPointGenerator) {
        if (isRight()) {
            return LEFT;
        }
        return next(ladderPointGenerator.generate());
    }

    public static Direction first(boolean right) {
        if(right) {
            return RIGHT;
        }
        return FORWARD;
        //return of(FALSE, right);
    }

    public Direction last() {
        if(isRight()) {
            return LEFT;
        }
        return FORWARD;
        //return of(this.right, FALSE);
    }

    @Override
    public String toString() {
        return "Direction{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}