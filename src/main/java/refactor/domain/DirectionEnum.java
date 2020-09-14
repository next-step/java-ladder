package refactor.domain;

import refactor.domain.pointGenerate.PointStrategy;

import static java.lang.Boolean.FALSE;

public enum DirectionEnum {

    LEFT(true, false),
    RIGTH(false,true),
    ALL_FALSE(false,false);

    private final boolean left;
    private final boolean right;

    DirectionEnum(boolean left, boolean right)  {
        if (left && right) {
            throw new IllegalStateException();
        }

        this.left = left;
        this.right = right;
    }

    public DirectionEnum next(boolean nextRight) {
        return valueOf(this.right, nextRight);
    }

    public DirectionEnum next(PointStrategy pointStrategy) {
        if(this.right) {
            return next(FALSE);
        }
        return next(pointStrategy.generatePoint());
    }

    public static DirectionEnum first(boolean right) {
        return valueOf(FALSE, right);
    }

    public DirectionEnum last() {
        return valueOf(this.right, FALSE);
    }

    public static DirectionEnum valueOf(boolean first, boolean second) {
        if(first) {
            return LEFT;
        }
        if(second) {
            return RIGTH;
        }
        return ALL_FALSE;
    }
}
