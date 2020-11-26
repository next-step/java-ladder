package domain;

import java.util.Random;

public class Point {
    private final boolean isPresent;

    public Point() {
        isPresent = new Random().nextBoolean();
    }

    public Point(final boolean isPresent) {
        this.isPresent = isPresent;
    }

    public boolean isPresent() {
        return isPresent;
    }
}
