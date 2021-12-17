package ladder;

import java.util.function.BooleanSupplier;

public class Point {

    private final boolean index;
    private final boolean left;

    public Point(BooleanSupplier randomPoint, boolean left) {
        if (left) {
            this.index = false;
        } else {
            this.index = randomPoint.getAsBoolean();
        }
        this.left = left;
    }

    public boolean isIndex() {
        return index;
    }

    public boolean getLeft() {
        return left;
    }
}
