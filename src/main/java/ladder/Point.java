package ladder;

import java.util.function.BooleanSupplier;

public class Point {

    private final boolean value;

    public Point(BooleanSupplier randomPoint) {
        this.value = randomPoint.getAsBoolean();
    }

    public boolean isValue() {
        return value;
    }
}
