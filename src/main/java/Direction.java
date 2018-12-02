public enum Direction {
    LEFT(true,false),
    RIGHT(false,true),
    STRAIGHT(false, false);


    Direction(boolean hasLeft, boolean hasRight) {
        this.hasLeft = hasLeft;
        this.hasRight = hasRight;
    }

    private boolean hasLeft;
    private boolean hasRight;

    public boolean isLeft() {
        return LEFT.equals(this);
    }

    public boolean isRight() {
        return RIGHT.equals(this);
    }

    public boolean isStraight() {
        return STRAIGHT.equals(this);
    }


}
