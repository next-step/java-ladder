package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {
    private final List<Player> players;

    public static Players of(List<String> playersAsString) {
        return new Players(
                IntStream.range(0, playersAsString.size())
                        .mapToObj(index -> new Player(playersAsString.get(index), Coordinate.of(index, 0)))
                        .collect(Collectors.toList())
        );
    }

    public Players(List<Player> players) {
        this.players = players;
    }

    public int countOfLines() {
        return players.size() - 1;
    }

    public List<Player> players() {
        return players;
    }

    public boolean sameLength(List<String> results) {
        return players.size() == results.size();
    }


}
