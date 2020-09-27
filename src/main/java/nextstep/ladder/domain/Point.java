package nextstep.ladder.domain;

import java.util.Random;

public class Point {
    public static final Random random = new Random();

    private final boolean exist;

    public Point(boolean exist) {
        this.exist = exist;
    }

    public static Point random() {
        return new Point(random.nextBoolean());
    }

    public static Point ofNotExist() {
        return new Point(false);
    }

    public boolean isExist() {
        return exist;
    }
}
