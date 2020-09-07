package cc.oakk.ladder.util;

public class StringUtils {
    private StringUtils() {}

    public static boolean isEmpty(String target) {
        return target == null || target.trim().isEmpty();
    }
}
