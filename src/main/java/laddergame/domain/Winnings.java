package laddergame.domain;

import java.util.List;

import static laddergame.exception.ExceptionMessage.WRONG_SIZE_OF_WINNINGS_MESSAGE;

public class Winnings {
    private static final int WINNINGS_MIN_NUMBER = 2;

    private final List<Winning> winnings;

    public Winnings(List<Winning> winnings) {
        validateWinnings(winnings);
        this.winnings = winnings;
    }

    private void validateWinnings(List<Winning> winnings) {
        if (winnings.size() < WINNINGS_MIN_NUMBER) {
            throw new IllegalArgumentException(String.format(WRONG_SIZE_OF_WINNINGS_MESSAGE.message(), WINNINGS_MIN_NUMBER));
        }
    }

    public static Winnings valueOf(List<Winning> winnings) {
        return new Winnings(winnings);
    }
}
