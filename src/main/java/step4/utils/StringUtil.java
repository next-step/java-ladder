package step4.utils;

public class StringUtil {
    private static final String COMMA = ",";

    public static String[] split(String names) {
        return names.split(COMMA);
    }
}
