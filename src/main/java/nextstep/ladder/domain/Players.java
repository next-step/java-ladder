package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import nextstep.ladder.exception.NotEnoughPlayersException;

public class Players {

    private static final int PLAYERS_MINIMUM_SIZE = 2;
    private static final int MINUS_NUMBER = 1;

    private final List<Name> players;

    public Players(List<Name> players) {
        valid(players);
        this.players = players;
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

    private void valid(List<Name> players) {
        if (players.isEmpty() || players.size() < PLAYERS_MINIMUM_SIZE) {
            throw new NotEnoughPlayersException(PLAYERS_MINIMUM_SIZE);
        }
    }

}
