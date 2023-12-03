package nextstep.step4.impl.util;

public class InputParser {
    public static final String INPUT_EMPTY_MSG = "빈 값을 입력 할수 없습니다.";
    private static final String SPLIT_TEXT = ",";

    public static String[] parse(String text) {
        emptyCheck(text);

        String[] tokens = split(text);

        return tokens;
    }

    private static void emptyCheck(String text) {
        if (isNullOrEmpty(text)) {
            throw new IllegalArgumentException(INPUT_EMPTY_MSG);
        }
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] split(String participantTexts) {
        return participantTexts.split(SPLIT_TEXT);
    }
}
