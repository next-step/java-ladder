package ladder.utils;

public class StringUtil {

    private StringUtil() {}

    public static boolean isEmpty(String value) {
        return null == value || value.trim().isEmpty();
    }
}
