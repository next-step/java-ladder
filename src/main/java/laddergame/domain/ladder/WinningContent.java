package laddergame.domain.ladder;

import java.util.Objects;

import static laddergame.domain.ladder.PlayersAndWinningContents.MAX_LENGTH_OF_PLAYER_AND_WINNING_CONTENT;
import static laddergame.exception.ExceptionMessage.WRONG_WINNING_MESSAGE;
import static laddergame.util.Validator.isNonBlank;

public class WinningContent {
    private final String winningContent;

    private WinningContent(String winningContent) {
        validateWinning(winningContent);
        this.winningContent = winningContent;
    }

    private void validateWinning(String winningContent) {
        if (!isNonBlank(winningContent) || winningContent.length() > MAX_LENGTH_OF_PLAYER_AND_WINNING_CONTENT) {
            throw new IllegalArgumentException(String.format(WRONG_WINNING_MESSAGE.message(), winningContent, MAX_LENGTH_OF_PLAYER_AND_WINNING_CONTENT));
        }
    }

    public static WinningContent valueOf(String winning) {
        return new WinningContent(winning);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        WinningContent that = (WinningContent) o;
        return Objects.equals(winningContent, that.winningContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningContent);
    }

    public String winningContent() {
        return winningContent;
    }
}
