package laddergame.domain;

import java.util.List;

import static laddergame.domain.PlayersAndWinningContents.MIN_NUMBER_OF_PLAYERS_AND_WINNING_CONTENTS;
import static laddergame.exception.ExceptionMessage.WRONG_SIZE_OF_WINNING_CONTENTS_MESSAGE;

public class WinningContents {
    private final List<WinningContent> winningContents;

    public WinningContents(List<WinningContent> winningContents) {
        validateWinnings(winningContents);
        this.winningContents = winningContents;
    }

    private void validateWinnings(List<WinningContent> winningContents) {
        if (winningContents.size() < MIN_NUMBER_OF_PLAYERS_AND_WINNING_CONTENTS) {
            throw new IllegalArgumentException(String.format(WRONG_SIZE_OF_WINNING_CONTENTS_MESSAGE.message(), MIN_NUMBER_OF_PLAYERS_AND_WINNING_CONTENTS));
        }
    }

    public int numberOfWinningContents() {
        return winningContents.size();
    }

    public WinningContent findWinningContentByIndex(int index) {
        return winningContents.get(index);
    }
}
