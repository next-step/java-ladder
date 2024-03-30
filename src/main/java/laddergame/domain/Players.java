package laddergame.domain;

import laddergame.exception.InvalidPlayersException;

import java.util.List;

public class Players {
    public static final int PLAYERS_MIN_NUMBER = 2;

    private final List<Player> players;

    private Players(List<Player> players) {
        validatePlayers(players);
        this.players = players;
    }

    private void validatePlayers(List<Player> players) {
        if(players.size() < PLAYERS_MIN_NUMBER) {
            throw new InvalidPlayersException();
        }
    }

    public static Players valueOf(List<Player> players) {
        return new Players(players);
    }

    public Player findPlayerByIndex(int index) {
        return players.get(index);
    }
}
