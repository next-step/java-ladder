package nextstep.ladder.domain.player;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.*;

public class Players {
    private final List<Player> players;

    public Players(List<String> names) {
        this.players = this.generatePlayers(names);
    }

    private List<Player> generatePlayers(List<String> names) {
        AtomicInteger index = new AtomicInteger();
        return names
                .stream()
                .map(name -> new Player(name, index.getAndIncrement()))
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));
    }

    public Player findPlayer(Player findPlayer) {
        return this.players.stream()
                .filter(player -> player.getName().equals(findPlayer.getName()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("not found player"));
    }

    public List<Player> getPlayers() {
        return this.players;
    }
}
