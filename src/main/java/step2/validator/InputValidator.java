package step2.validator;

public class InputValidator {

    public static boolean validateParseInt(String input) {
        boolean isValid = input.chars().allMatch(Character::isDigit);
        if (!isValid) {
            throw new IllegalArgumentException("입력값에 숫자 이외의 값이 입력되었습니다.");
        }
        return true;
    }
}
