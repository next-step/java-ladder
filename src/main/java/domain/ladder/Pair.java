package domain.ladder;

public class Pair {

    private static final int NEXT = 1;

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

    public static Pair single() {
        return new Pair(Boolean.FALSE, Boolean.FALSE);
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public int next(int current) {
        if (isLeft()) {
            return toLeft(current);
        }
        if (isRight()) {
            return toRight(current);
        }

        return current;
    }

    private int toLeft(int current) {
        return current - NEXT;
    }

    private int toRight(int current) {
        return current + NEXT;
    }
}
