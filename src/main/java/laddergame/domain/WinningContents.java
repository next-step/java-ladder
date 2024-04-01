package laddergame.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static laddergame.domain.PlayersAndWinningContents.MIN_NUMBER_OF_PLAYERS_AND_WINNING_CONTENTS;
import static laddergame.exception.ExceptionMessage.WRONG_SIZE_OF_WINNINGS_MESSAGE;

public class WinningContents {
    private final List<WinningContent> winningContents;

    private WinningContents(String... winnings) {
        this(Arrays.stream(winnings)
                .map(WinningContent::valueOf)
                .collect(Collectors.toList()));
    }

    private WinningContents(List<WinningContent> winningContents) {
        validateWinnings(winningContents);
        this.winningContents = winningContents;
    }

    private void validateWinnings(List<WinningContent> winningContents) {
        if (winningContents.size() < MIN_NUMBER_OF_PLAYERS_AND_WINNING_CONTENTS) {
            throw new IllegalArgumentException(String.format(WRONG_SIZE_OF_WINNINGS_MESSAGE.message(), MIN_NUMBER_OF_PLAYERS_AND_WINNING_CONTENTS));
        }
    }

    public static WinningContents newWinningContents(String... winnings) {
        return new WinningContents(winnings);
    }

    public static WinningContents valueOf(List<WinningContent> winningContents) {
        return new WinningContents(winningContents);
    }

    public int numberOfWinningContents() {
        return winningContents.size();
    }
}
