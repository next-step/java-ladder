package laddergame.domain;

import static laddergame.exception.ExceptionMessage.WRONG_PLAYERS_AND_WINNING_CONTENTS_MESSAGE;

public class PlayersAndWinningContents {
    public final static int MAX_LENGTH_OF_PLAYER_AND_WINNING_CONTENT = 5;
    public final static int MIN_NUMBER_OF_PLAYERS_AND_WINNING_CONTENTS = 2;

    private final Players players;
    private final WinningContents winningContents;

    private PlayersAndWinningContents(Players players, WinningContents winningContents) {
        validatePlayersAndWinnings(players, winningContents);
        this.players = players;
        this.winningContents = winningContents;
    }

    private void validatePlayersAndWinnings(Players players, WinningContents winningContents) {
        if (players.numberOfPlayers() != winningContents.numberOfWinningContents()) {
            throw new IllegalArgumentException(WRONG_PLAYERS_AND_WINNING_CONTENTS_MESSAGE.message());
        }
    }

    public static PlayersAndWinningContents newPlayersAndWinnings(Players players, WinningContents winningContents) {
        return new PlayersAndWinningContents(players, winningContents);
    }

    public int numberOfLinks() {
        return players.numberOfPlayers() - 1;
    }

    public int numberOfPlayers() {
        return players.numberOfPlayers();
    }

    public Player findPlayerByIndex(int index) {
        return players.findPlayerByIndex(index);
    }

    public WinningContent findWinningContentByIndex(int index) {
        return winningContents.findWinningContentByIndex(index);
    }

    public Players players() {
        return players;
    }

    public WinningContents winningContents() {
        return winningContents;
    }
}
