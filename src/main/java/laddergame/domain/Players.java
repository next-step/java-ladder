package laddergame.domain;

import laddergame.exception.InvalidPlayersException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    public static final int PLAYERS_MIN_NUMBER = 2;

    private final List<Player> players;

    private Players(String... players) {
        this(Arrays.stream(players)
                .map(Player::valueOf)
                .collect(Collectors.toList()));
    }

    private Players(Player... players) {
        this(List.of(players));
    }

    private Players(List<Player> players) {
        validatePlayers(players);
        this.players = players;
    }

    private void validatePlayers(List<Player> players) {
        int sizeOfPlayers = players.size();
        int sizeOfPlayersSet = new HashSet<>(players).size();

        if(sizeOfPlayers < PLAYERS_MIN_NUMBER || sizeOfPlayers > sizeOfPlayersSet) {
            throw new InvalidPlayersException();
        }
    }

    public static Players newPlayers(String... players) {
        return new Players(players);
    }

    public static Players newPlayers(Player... players) {
        return new Players(players);
    }

    public static Players valueOf(List<Player> players) {
        return new Players(players);
    }

    public Player findPlayerByIndex(int index) {
        return players.get(index);
    }

    public int numberOfPlayers() {
        return players.size();
    }

    public List<Player> players() {
        return players;
    }
}
