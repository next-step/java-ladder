package ladder.domain;

public class PlayResult {
    private static final int RESULT_MAX_LENGTH = 5;
    private static final int RESULT_MIN_LENGTH = 1;

    private final String result;
    private final int order;

    public static PlayResult of(String input, int order) {
        return new PlayResult(input, order);
    }

    private PlayResult(String input, int order) {
        validate(input, order);
        this.result = input;
        this.order = order;
    }

    public String getResult() {
        return result;
    }

    public boolean isOrder(int order) {
        return this.order == order;
    }

    private void validate(String input, int order) {
        if (order < 1) {
            throw new IllegalArgumentException("순서는 0보다 커야 합니다.");
        }
        if (input.length() > RESULT_MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("결과 내용길이가 %d보다 깁니다.", RESULT_MAX_LENGTH));
        }
        if (input.length() < RESULT_MIN_LENGTH) {
            throw new IllegalArgumentException(String.format("결과 내용길이가 %d보다 짧습니다.", RESULT_MIN_LENGTH));
        }
    }
}
