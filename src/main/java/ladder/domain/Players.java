package ladder.domain;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

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
        AtomicInteger index = new AtomicInteger();
        return Arrays.stream(names.split(SEPARATOR))
                     .map(name -> new Player(name, index.getAndIncrement()))
                     .collect(Collectors.toList());
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