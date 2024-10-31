package nextstep.ladder.domain;

import java.util.Random;

public class Point {
    private static final Random random = new Random();
    private static final String LADDER_POINT = "-----|";
    private static final String EMPTY_POINT = "     |";
    private final boolean left;
    private final boolean right;

    private Point(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public Point() {
        this(false, random.nextBoolean());
    }

    public Point(Point previousPoint) {
        this(previousPoint.right, validateRight(previousPoint));
    }


    private static boolean validateRight(Point previousPoint) {
        if (previousPoint.right) {
            return false;
        }
        return random.nextBoolean();
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    @Override
    public String toString() {
        return right ? LADDER_POINT : EMPTY_POINT;
    }
}
