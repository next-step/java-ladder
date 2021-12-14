package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.exception.NotEnoughPlayersException;

public class Players {

    private static final int PLAYERS_MINIMUM_SIZE = 2;
    private static final int MINUS_NUMBER = 1;

    private final List<Name> players;

    private Players(List<Name> players) {
        this.players = players;
    }

    public static Players of(InputString playerName) {
        List<Name> players = Arrays.stream(playerName.split())
            .map(Name::of)
            .collect(Collectors.toCollection(ArrayList::new));

        valid(players);
        return new Players(players);
    }

    public Name getPlayer(int index) {
        return players.get(index);
    }

    public List<Name> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public int size() {
        return players.size();
    }

    public int width() {
        return size() - MINUS_NUMBER;
    }

    public boolean isSize(int size) {
        return players.size() == size;
    }

    private static void valid(List<Name> players) {
        if (players.isEmpty() || players.size() < PLAYERS_MINIMUM_SIZE) {
            throw new NotEnoughPlayersException(PLAYERS_MINIMUM_SIZE);
        }
    }

}
