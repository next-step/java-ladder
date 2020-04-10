package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Players {
    private static final String SEPARATOR = ",";

    private final List<Player> players;

    public Players(final List<Player> players) {
        this.players = Collections.unmodifiableList(players);
    }

    public Players (final String names) {
        this.players = Collections.unmodifiableList(createPlayers(names));
    }

    public int count() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }

    private List<Player> createPlayers(final String names) {
        String[] splitNames = names.split(SEPARATOR);
        List<Player> players = new ArrayList<>();
        for (int index = 0; index < splitNames.length; index++) {
            players.add(new Player(splitNames[index], index));
        }
        return players;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Players players1 = (Players) o;
        return Objects.equals(players, players1.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }
}