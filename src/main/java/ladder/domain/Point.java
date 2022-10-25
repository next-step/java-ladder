package ladder.domain;

import java.util.Random;

public class Point {
    private final boolean exist;

    public Point() {
        this(new Random().nextBoolean());
    }

    public Point(boolean exist) {
        this.exist = exist;
    }

    public boolean isExist() {
        return exist;
    }

    Point nextPoint() {
        if (isExist()) {
            return new Point(false);
        }
        return new Point();
    }
}
