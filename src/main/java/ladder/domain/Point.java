package ladder.domain;

import java.util.Random;

public class Point {
    public static final String LINE_EXIST = "|-----";
    public static final String LINE_NO_EXIST = "|     ";
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

    public String getPointExist() {
        if (exist) return LINE_EXIST;
        return LINE_NO_EXIST;
    }
}
