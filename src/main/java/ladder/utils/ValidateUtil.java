package ladder.utils;

public class ValidateUtil {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String INVALID_MAX_NAME_LENGTH_MESSAGE = "이름은 최대 5글자까지 허용됩니다.";
    private static final String INVALID_NAME_BLANK_MESSAGE = "이름에 공백은 허용되지 않습니다.";

    public static void validateInputName(String name) {
        validateNameLength(name);
        validateNameIsBlank(name);
    }

    private static void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_MAX_NAME_LENGTH_MESSAGE);
        }
    }

    private static void validateNameIsBlank(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME_BLANK_MESSAGE);
        }
    }
}
