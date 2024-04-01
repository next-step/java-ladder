package laddergame.domain.ladder;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static laddergame.domain.ladder.PlayersAndWinningContents.MIN_NUMBER_OF_PLAYERS_AND_WINNING_CONTENTS;
import static laddergame.exception.ExceptionMessage.WRONG_SIZE_OF_PLAYERS_MESSAGE;

public class Players {
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

        if (sizeOfPlayers < MIN_NUMBER_OF_PLAYERS_AND_WINNING_CONTENTS || sizeOfPlayers > sizeOfPlayersSet) {
            throw new IllegalArgumentException(String.format(WRONG_SIZE_OF_PLAYERS_MESSAGE.message(), MIN_NUMBER_OF_PLAYERS_AND_WINNING_CONTENTS));
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
        return Collections.unmodifiableList(players);
    }
}
