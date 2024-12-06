import java.util.HashMap;
import java.util.Map;

public class PointCache {
    private static final Map<Integer, Map<Integer, Point>> cache = new HashMap<>();

    public static Point get(int x, int y) {
        if (!cache.containsKey(x)) {
            Map<Integer, Point> subCache = new HashMap<>();

            subCache.put(y, new Point(x, y));
            cache.put(x, subCache);
        }

        if (!cache.get(x).containsKey(y)) {
            cache.get(x).put(y, new Point(x, y));
        }

        return cache.get(x).get(y);
    }
}
