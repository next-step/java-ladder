package ladder.domain;

import ladder.common.Constants;

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

    public static Boolean isEqual(Point randomPoint, Point beforePoint) {
        return randomPoint.point == beforePoint.point;
    }

    public String beautify() {
        StringBuilder builder = new StringBuilder();
        String fill = " ";
        if (point) {
            fill = "-";
        }
        for (int i = 0; i < Constants.Person.MAX_NAME_LENGTH; i++) {
            builder.append(fill);
        }
        return builder.toString();
    }
}
