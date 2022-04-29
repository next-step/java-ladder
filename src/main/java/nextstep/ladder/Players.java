package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Collections.*;

public class Players {

    private final List<Player> players = new ArrayList<>();

    private Players(String[] playersNames) {
        for (String playerName : playersNames) {
            players.add(new Player(new PlayerName(playerName)));
        }
    }

    public static Players getNewInstanceByStrings(String[] playersNames) {
        return new Players(playersNames);
    }

    public List<Player> getPlayers() {
        return unmodifiableList(players);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players players1 = (Players) o;
        return Objects.equals(players, players1.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }
}
