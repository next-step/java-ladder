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

    public static Direction first(Boolean right) {
        if( right ) {
            return RIGHT;
        }

        return STRAIGHT;
    }

    public Direction last() {
        if(isRight()) {
            return LEFT;
        }
        return STRAIGHT;
    }

    public boolean isLeft() {
        return LEFT.equals(this);
    }

    public boolean isRight() {
        return RIGHT.equals(this);
    }

    public boolean isStraight() {
        return STRAIGHT.equals(this);
    }

    public Direction next(LadderLineGenerator ladderLineGenerator) {
        if( this.isRight() ) {
            return LEFT;
        }

        return next(ladderLineGenerator.generatePoint());
    }

    public Direction next(boolean nextRight) {
       if(nextRight) {
           return RIGHT;
       }

       return STRAIGHT;
    }

    @Override
    public String toString() {
        return "Direction{" +
                "hasLeft=" + hasLeft +
                ", hasRight=" + hasRight +
                '}';
    }
}
