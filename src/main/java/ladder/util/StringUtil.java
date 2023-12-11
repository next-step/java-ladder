package ladder.util;

public class StringUtil {
    private static final String SEPARATOR = ",";
    private StringUtil(){}

    public static String[] split(String str) {
        return str.split(SEPARATOR);
    }

}
