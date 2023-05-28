package step3.domain;

public class InputValidator {
    private InputValidator() {
    }

    public static void validateHeight(int height) {
        if (height < 1) {
            throw new IllegalArgumentException("사다리 높이는 0보다 커야 합니다.");
        }
    }
}
