package step4.utils;

public class IntegerUtil {

    public static int parseInt(String input) {
        validateDigit(input);
        return Integer.parseInt(input);
    }

    private static void validateDigit(String input) {
        boolean isDigit = input.chars().allMatch(Character::isDigit);
        if (!isDigit) {
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.");
        }
    }
}
