package ladder.domain;

import java.util.Random;

public class Point {
    private Boolean point;

    public Point(Boolean point) {
        this.point = point;
    }

    public static Point generateRandom() {
        return new Point(new Random().nextBoolean());
    }

    public static Point reverse(Point target) {
        return new Point(!target.point);
    }

    public static Boolean isTrueOverlap(Point randomPoint, Point beforePoint) {
        return randomPoint.point && beforePoint.point;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        String fill = " ";
        if (point) {
            fill = "-";
        }
        for (int i = 0; i < Person.MAX_NAME_LENGTH; i++) {
            builder.append(fill);
        }
        return builder.toString();
    }
}
