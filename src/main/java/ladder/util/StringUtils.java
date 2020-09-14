package ladder.util;

public class StringUtils {
    public StringUtils() {
    }

    public static boolean validEmpty(String target) {
        return target == null || target == "" || "".equals(target.trim());
    }
}
