package ladder.domain;

public class Points {
    private boolean left;
    private boolean right;

    private Points(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public boolean isRight() {
        return this.right;
    }

    public boolean isLeft() {
        return this.left;
    }

    public static Points of(boolean left, boolean right) {
        return new Points(left, right);
    }

    public static Points getFirst(boolean right) {
        return new Points(false, right);
    }

    public static Points getLast(boolean left) {
        return new Points(left, false);
    }

    public static Points next(Points old, boolean right) {
        if (old.isRight()) {
            return new Points(old.isRight(), false);
        }
        return new Points(false, right);
    }

}
