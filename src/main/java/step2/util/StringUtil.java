package step2.util;

public class StringUtil {
    private static final String DELIMITER = ",";

    public static String [] split(String words) {
        return words.split(DELIMITER);
    }
}
