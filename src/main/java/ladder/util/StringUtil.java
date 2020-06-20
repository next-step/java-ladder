package ladder.util;

import java.util.Objects;

public class StringUtil {

    private static final String DELIMITER = ",";

    public static String [] split(String words) {
        validateNull(words);
        return words.split(DELIMITER);
    }

    public static void validateNull(String word) {
        if (Objects.isNull(word) || word.isEmpty()){
            throw new IllegalArgumentException(NAME_NULL_EXCEPTION);
        }
    }
}
