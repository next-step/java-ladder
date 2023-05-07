package nextstep.ladder.domain;

public class Input {
    private static final int INPUT_MAX_LENGTH = 5;

    private final String input;

    public Input(String input) {
        checkInputRule(input);
        this.input = input;
    }

    private void checkInputRule(String input) {
        hasNullOrEmpty(input);
        overLengthRule(input);
    }

    private void hasNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("값을 입력해주세요.");
        }
    }

    private void overLengthRule(String input) {
        if (input.length() > INPUT_MAX_LENGTH) {
            throw new IllegalArgumentException("5글자를 초과할 수 없습니다.");
        }
    }

    public String getInput() {
        return input;
    }
}
