package step4_ladderGame.domain;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Players {

    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players of(String[] names) {
        List<Player> players = IntStream.range(0, names.length)
                .mapToObj(index -> Player.of(names[index], index))
                .collect(toList());
        return Players.of(players);
    }

    public static Players of(List<Player> players) {
        return new Players(players);
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }

    public int size() {
        return players.size();
    }

    public Players play(Ladder ladder) {
        return players.stream()
                .map(ladder::move)
                .collect(collectingAndThen(toList(), Players::new));
    }
}
