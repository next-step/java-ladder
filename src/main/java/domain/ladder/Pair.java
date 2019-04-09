package domain.ladder;

public class Pair {
    private boolean left;
    private boolean right;

    public Pair() {
    }

    public Pair(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Pair first(boolean right) {
        return new Pair(Boolean.FALSE, right);
    }

    public static Pair last(boolean left) {
        return new Pair(left, Boolean.FALSE);
    }

    public static Pair middle(boolean left, boolean right) {
        return new Pair(left, right);
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }
}
