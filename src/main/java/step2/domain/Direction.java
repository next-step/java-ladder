package step2.domain;

public class Direction {
    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Direction first(BooleanGenerator booleanGenerator) {
        return new Direction(false, booleanGenerator.nextBoolean());
    }

    public static Direction middle(boolean isLeft, BooleanGenerator booleanGenerator) {
        if(isLeft){
            return new Direction(true, false);
        }
        return new Direction(false, booleanGenerator.nextBoolean());
    }

    public static Direction last(boolean left) {
        return new Direction(left, false);
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

}
