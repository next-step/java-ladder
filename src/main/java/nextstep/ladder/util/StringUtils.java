package nextstep.ladder.util;

public class StringUtils {

    private final static String SPLIT_SEPERATOR = ",";

    private StringUtils() {
    }

    public static String[] split(String input) {
        return input.split(SPLIT_SEPERATOR);
    }
}
