package domain;

import java.util.Random;

public class Point {
    private boolean isPresent;

    public Point() {
        isPresent = new Random().nextBoolean();
    }

    public Point(boolean isPresent) {
        this.isPresent = isPresent;
    }

    public boolean isPresent() {
        return isPresent;
    }
}
