package laddergame.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static laddergame.domain.PlayersAndWinningContents.MIN_NUMBER_OF_PLAYERS_AND_WINNING_CONTENTS;
import static laddergame.exception.ExceptionMessage.WRONG_SIZE_OF_WINNINGS_MESSAGE;

public class WinningContents {
    private final List<WinningContent> winningContents;

    private WinningContents(List<WinningContent> winningContents) {
        validateWinnings(winningContents);
        this.winningContents = winningContents;
    }

    private void validateWinnings(List<WinningContent> winningContents) {
        if (winningContents.size() < MIN_NUMBER_OF_PLAYERS_AND_WINNING_CONTENTS) {
            throw new IllegalArgumentException(String.format(WRONG_SIZE_OF_WINNINGS_MESSAGE.message(), MIN_NUMBER_OF_PLAYERS_AND_WINNING_CONTENTS));
        }
    }

    public static WinningContents valueOf(List<WinningContent> winningContents) {
        return new WinningContents(winningContents);
    }

    public static WinningContents newWinningContents(String... winningContents) {
        return new WinningContents(Arrays.stream(winningContents)
                .map(WinningContent::valueOf)
                .collect(Collectors.toList()));
    }

    public static WinningContents newWinningContents(WinningContent... winningContents) {
        return new WinningContents(List.of(winningContents));
    }

    public int numberOfWinningContents() {
        return winningContents.size();
    }

    public List<WinningContent> winningContents() {
        return Collections.unmodifiableList(winningContents);
    }

    public WinningContent findWinningContentByIndex(int index) {
        return winningContents.get(index);
    }
}
