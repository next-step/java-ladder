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
            return points.get(points.size()-1) != VERTICAL_LINE || points.get(points.size()-2) != HORIZON;
        } catch (IndexOutOfBoundsException e) {
            return true;
        }
    }
}
