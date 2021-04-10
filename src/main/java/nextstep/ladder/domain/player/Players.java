package nextstep.ladder.domain.player;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Players {

    private final List<Player> playerList;

    private Players(List<Player> playerList) {
        this.playerList = playerList;
    }

    public static Players of(List<String> playerNames) {
        return IntStream.range(0, playerNames.size())
                        .mapToObj(i -> Player.of(playerNames.get(i), i))
                        .collect(collectingAndThen(toList(), Players::new));
    }

    public Player getPlayerBy(String name) {
        return playerList.stream()
                         .filter(player -> player.hasName(name))
                         .findFirst()
                         .orElseThrow(NoSuchElementException::new);
    }

    public Stream<Player> stream() {
        return playerList.stream();
    }

}
