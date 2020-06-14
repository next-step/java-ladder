package laddergame.domain.player;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {
    private final List<Player> players;

    public Players(String[] names) {
        this.players = createPlayers(names);
    }

    private List<Player> createPlayers(String[] names) {
        return IntStream.range(0, names.length)
                .mapToObj(column -> new Player(names[column], column + 1))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
