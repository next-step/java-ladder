package laddergame.domain;

import static laddergame.exception.ExceptionMessage.WRONG_WINNING_MESSAGE;
import static laddergame.util.Validator.isNonBlank;

public class Winning {
    private static final int MAX_WINNING_LENGTH = 5;
    private final String winning;

    private Winning(String winning) {
        validateWinning(winning);
        this.winning = winning;
    }

    private void validateWinning(String winning) {
        if (!isNonBlank(winning) || winning.length() > MAX_WINNING_LENGTH) {
            throw new IllegalArgumentException(String.format(WRONG_WINNING_MESSAGE.message(), winning, MAX_WINNING_LENGTH));
        }
    }

    public static Winning valueOf(String winning) {
        return new Winning(winning);
    }
}
