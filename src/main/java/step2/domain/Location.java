package step2;

public class Location {
    private final boolean left;
    private final boolean right;

    public Location(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }


}
