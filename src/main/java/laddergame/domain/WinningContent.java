package laddergame.domain;

import static laddergame.domain.PlayersAndWinningContents.MAX_LENGTH_OF_PLAYER_AND_WINNING_CONTENT;
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
}
