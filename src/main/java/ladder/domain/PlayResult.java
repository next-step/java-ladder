package ladder.domain;

public class PlayResult {
    private static final int RESULT_MAX_LENGTH = 5;
    private static final int RESULT_MIN_LENGTH = 1;

    private final String result;

    public static PlayResult of(String input) {
        return new PlayResult(input);
    }

    private PlayResult(String input) {
        validate(input);
        this.result = input;
    }

    public String getResult() {
        return result;
    }

    private void validate(String input) {
        if (input.length() > RESULT_MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("결과 내용길이가 %d보다 깁니다.", RESULT_MAX_LENGTH));
        }
        if (input.length() < RESULT_MIN_LENGTH) {
            throw new IllegalArgumentException(String.format("결과 내용길이가 %d보다 짧습니다.", RESULT_MIN_LENGTH));
        }
    }
}
