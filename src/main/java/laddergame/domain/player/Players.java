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

    public Player findByName(String name) {
        return players.stream()
                .filter(player -> player.isSameName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 이름입니다. - " + name));
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
