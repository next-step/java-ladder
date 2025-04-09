package nextstep.ladder;

public class StringParser {
    private static final String DELIMITER = ",";

    public static String[] parse(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값은 null 또는 빈 문자열일 수 없습니다.");
        }

        return input.split(DELIMITER);
    }
}
