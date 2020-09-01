package nextstep.ladder.utils;

public class StringUtils {

    private static final String INPUT_NAME_DELIMITER = ", |,";

    private StringUtils() {
    }

    public static String[] splitBy(String inputValue) {
        return inputValue.split(INPUT_NAME_DELIMITER);
    }

}
