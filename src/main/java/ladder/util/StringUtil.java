package ladder.util;

import java.util.Objects;

public class StringUtil {

    public static final String SPLIT_WORDS_EXCEPTION = "빈 값을 입력할 수 없습니다.";

    private static final String DELIMITER = ",";

    public static String [] split(String words) {
        validateNull(words, SPLIT_WORDS_EXCEPTION);
        return words.split(DELIMITER);
    }

    public static void validateNull(String word, String exceptionMessage) {
        if (Objects.isNull(word) || word.isEmpty()){
            throw new IllegalArgumentException(exceptionMessage);
        }
    }
}
