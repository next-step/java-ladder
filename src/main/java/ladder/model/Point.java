package ladder.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Point {

    private static final Map<Boolean,Point> POINT_CACHE = new HashMap<>();
    private static final Random random = new Random();
    private final boolean isLine;

    static {
        POINT_CACHE.put(false, new Point(false));
        POINT_CACHE.put(true, new Point(true));
    }

    private Point(boolean isLine){
        this.isLine = isLine;
    }

    public static Point first() {
        return Point.of(false);
    }

    public static Point of(boolean isLine) {
        return POINT_CACHE.get(isLine);
    }

    public Point next() {
        if(this.isLine) {
            return Point.of(false);
        }
        return Point.of(random.nextBoolean());
    }

    public boolean getIsLine() {
        return this.isLine;
    }

    public String draw() {
        String value = getIsLine() ? "-" : " ";
        return String.join("",Collections.nCopies(5, value)) + "|";
    }
}