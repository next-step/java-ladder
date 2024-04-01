package laddergame.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static laddergame.exception.ExceptionMessage.WRONG_SIZE_OF_WINNINGS_MESSAGE;

public class Winnings {
    private static final int WINNINGS_MIN_NUMBER = 2;

    private final List<Winning> winnings;

    private Winnings(String... winnings) {
        this(Arrays.stream(winnings)
                .map(Winning::valueOf)
                .collect(Collectors.toList()));
    }

    private Winnings(List<Winning> winnings) {
        validateWinnings(winnings);
        this.winnings = winnings;
    }

    private void validateWinnings(List<Winning> winnings) {
        if (winnings.size() < WINNINGS_MIN_NUMBER) {
            throw new IllegalArgumentException(String.format(WRONG_SIZE_OF_WINNINGS_MESSAGE.message(), WINNINGS_MIN_NUMBER));
        }
    }

    public static Winnings newWinnings(String... winnings) {
        return new Winnings(winnings);
    }

    public static Winnings valueOf(List<Winning> winnings) {
        return new Winnings(winnings);
    }

    public int numberOfWinnings() {
        return winnings.size();
    }
}
