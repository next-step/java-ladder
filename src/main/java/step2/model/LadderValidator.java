package step2.model;

public class LadderValidator {
    public static void isBlank(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("아무것도 입력하지 않았습니다. 다시 입력해주세요");
        }
    }
}
