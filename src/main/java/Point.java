

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class Point {
    private boolean point;
    private static final Map<Boolean, Point> POINT = new HashMap<>();

    public Point(boolean point){
        this.point = point;
    }

    static{
        POINT.put(true, new Point(true));
        POINT.put(false, new Point(false));
    }

    static Point of(Boolean value){
        return POINT.get(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point1 = (Point) o;
        return point == point1.point;
    }

    @Override
    public int hashCode() {
        return Objects.hash(point);
    }

    @Override
    public String toString() {
        if(point){
            return "-----|";
        }
        return "-----";
    }
}
