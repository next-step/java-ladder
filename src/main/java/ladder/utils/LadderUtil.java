package ladder.utils;

public class LadderUtil {
    private static final String COMMA_DELIMITER = ",";

    private LadderUtil() {
    }

    public static String[] separateLineWithComma(final String line) {
        return line.split(COMMA_DELIMITER);
    }
}
