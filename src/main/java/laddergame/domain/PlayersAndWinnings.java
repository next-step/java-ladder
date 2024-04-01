package laddergame.domain;

import static laddergame.exception.ExceptionMessage.WRONG_PLAYERS_AND_WINNINGS_MESSAGE;

public class PlayersAndWinnings {
    private final Players players;
    private final Winnings winnings;

    private PlayersAndWinnings(Players players, Winnings winnings) {
        validatePlayersAndWinnings(players, winnings);
        this.players = players;
        this.winnings = winnings;
    }

    private void validatePlayersAndWinnings(Players players, Winnings winnings) {
        if (players.numberOfPlayers() != winnings.numberOfWinnings()) {
            throw new IllegalArgumentException(WRONG_PLAYERS_AND_WINNINGS_MESSAGE.message());
        }
    }

    public static PlayersAndWinnings newPlayersAndWinnings(Players players, Winnings winnings) {
        return new PlayersAndWinnings(players, winnings);
    }
}
