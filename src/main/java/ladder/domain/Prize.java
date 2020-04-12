package ladder.domain;

public class Prize {
    private static final int PRIZE_MAX_LENGTH = 5;
    private static final int PRIZE_MIN_LENGTH = 1;

    private final String prize;

    public static Prize of(String input) {
        return new Prize(input);
    }

    private Prize(String input) {
        validate(input);
        this.prize = input;
    }

    public String getPrize() {
        return this.prize;
    }

    private void validate(String input) {
        if (input.length() > PRIZE_MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("결과 내용길이가 %d보다 깁니다.", PRIZE_MAX_LENGTH));
        }
        if (input.length() < PRIZE_MIN_LENGTH) {
            throw new IllegalArgumentException(String.format("결과 내용길이가 %d보다 짧습니다.", PRIZE_MIN_LENGTH));
        }
    }
}
