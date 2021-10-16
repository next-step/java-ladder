package ladder;

import ladder.util.RandomCustom;

public class Point {

    private final boolean value;

    public Point() {
        this.value = RandomCustom.nextBoolean();
    }

    public boolean isValue() {
        return value;
    }
}
