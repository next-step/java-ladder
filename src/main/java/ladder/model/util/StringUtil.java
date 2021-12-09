package ladder.model.util;

public class StringUtil {

    private StringUtil() {}

    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
