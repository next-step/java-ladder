package ladder.util;

import java.util.Arrays;
import java.util.List;

public class StringUtil {
    private static final String COMMA = ",";
    private static final String EMPTY = "";
    private static final String BLANK = "";
    private static final String SPACE = " ";

    private StringUtil(){
    }

    public static boolean isEmpty(String text) {
        return null == text || EMPTY.equals(text);
    }

    public static List<String> convertList(String text) {
        if (isEmpty(text)) {
            throw new IllegalArgumentException("입력 값이 없습니다.");
        }
        text = removeBlank(text.trim());
        return Arrays.asList(text.split(COMMA));
    }

    private static String removeBlank(String input) {
        return input.replace(SPACE, BLANK);
    }
}
