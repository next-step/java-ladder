package ladder.domain;

import java.util.List;

public enum Point {
    VERTICAL_LINE, HORIZON, BLANK;
    
    public static List<Point> next(Point now) {
        if (now == VERTICAL_LINE) {
            return List.of(HORIZON, BLANK);
        }
        return List.of(VERTICAL_LINE);
    } 

    public static boolean canAddHorizonNextTime(final List<Point> points) {
        try {
            return isNotVerticalLine(points.get(points.size() - 1)) || isNotHorizon(points.get(points.size() - 2));
        } catch (IndexOutOfBoundsException e) {
            return true;
        }
    }
    
    private static boolean isNotVerticalLine(Point before) {
        return VERTICAL_LINE != before;
    }
    
    private static boolean isNotHorizon(Point before) {
        return HORIZON != before;
    }
}
