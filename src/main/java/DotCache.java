import java.util.HashMap;
import java.util.Map;

public class DotCache {
    private static final Map<Point, Dot> cache = new HashMap<>();

    public static void put(Point point, Dot dot) {
        cache.put(point, dot);
    }

    public static Dot get(int x, int y) {
        Point p = PointCache.get(x, y);

        if (!cache.containsKey(p)) {
            throw new RuntimeException("DotCache must have instance at (X: " + x + ", Y: " + y + ")");
        }

        return cache.get(p);
    }
}
