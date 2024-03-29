package ladder;

import ladder.domain.Point;
import ladder.error.ErrorMessage;

import java.util.function.BiPredicate;

public class Lambda {

    public static Point decidePointExist(Point point1, Point point2, BiPredicate<Point, Point> predicate) {
        if (predicate.test(point1, point2)) {
            return new Point(false);
        }
        return point2;
    }

    public static void validatePoint(Point p1, Point p2, BiPredicate<Point, Point> predicate) {
        if (predicate.test(p1,p2)) {
            throw new IllegalArgumentException(ErrorMessage.ERR_INVALID_POINT.print());
        }
    }

    public static void validateLength(String name, int number, BiPredicate<String , Integer> predicate) {
        if (predicate.test(name, number)) {
            throw new IllegalArgumentException(ErrorMessage.ERR_OUT_OF_LENGTH.print());
        }
    }
}