package ladder.domain;

public class Bar {

    private final boolean left;
    private final boolean right;

    private Bar(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Bar of(boolean left, boolean right) {
        return new Bar(left, right);
    }

    Position move(Position position) {
        if (left && !right) {
            position.moveToLeft();
        }
        if (!left && right) {
            position.moveToRight();
        }
        return position;
    }

    public boolean hasRight() {
        return right;
    }
}
