package ladder.domain;

import static java.lang.Boolean.FALSE;

public enum DirectionType {
    LEFT(true, false),
    RIGHT(false, true),
    CENTER(false, false);

    private boolean left;
    private boolean right;

    DirectionType(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isCenter() {
        return !left && !right;
    }

    public static DirectionType of(boolean left, boolean right) {
        if(left && !right) return LEFT;
        if(!left && right) return RIGHT;
        if(!left && !right) return CENTER;
        throw new IllegalStateException();
    }

    public DirectionType next(boolean nextRight) {
        return of(this.right, nextRight);
    }

    public DirectionType next(BooleanGenerator booleanGenerator) {
        if(this.right) {
            return next(FALSE);
        }

        return next(booleanGenerator.generatePoint());
    }

    public static DirectionType first(boolean right) {
        return of(FALSE, right);
    }

    public DirectionType last() {
        return of(this.right, FALSE);
    }
}
