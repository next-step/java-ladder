package laddergame.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static laddergame.domain.PlayersAndWinningContents.MIN_NUMBER_OF_PLAYERS_AND_WINNING_CONTENTS;
import static laddergame.exception.ExceptionMessage.WRONG_SIZE_OF_PLAYERS_MESSAGE;

public class Players {
    private static final String ALL_PLAYERS = "ALL";

    private final List<Player> players;

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

    public static Players valueOf(List<Player> players) {
        return new Players(players);
    }

    public static Players newPlayers(String... players) {
        return new Players(Arrays.stream(players)
                .map(Player::valueOf)
                .collect(Collectors.toList()));
    }

    public static Players newPlayers(Player... players) {
        return new Players(List.of(players));
    }

    public Player findPlayerByIndex(int index) {
        return players.get(index);
    }

    public List<Player> findPlayersByName(String name) {
        if (ALL_PLAYERS.equals(name)) {
            return Collections.unmodifiableList(players);
        }

        Player targetOfFinding = Player.valueOf(name);

        return players.stream()
                .filter(player -> player.equals(targetOfFinding))
                .collect(Collectors.toList());
    }

    public int numberOfPlayers() {
        return players.size();
    }

    public List<Player> players() {
        return Collections.unmodifiableList(players);
    }
}
