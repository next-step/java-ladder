package ladder.domain;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {
    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players.stream()
                .distinct()
                .collect(Collectors.toUnmodifiableList());
    }

    public int countOfPlayer() {
        return players.size();
    }

    public Optional<Integer> findIndexByName(String name) {
        return IntStream.range(0, players.size())
                .filter(i -> players.get(i).getName().equals(name))
                .boxed()
                .findFirst();
    }

    public String getName(int idx) {
        return players.get(idx).getName();
    }

    public List<String> getNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    public int size() {
        return players.size();
    }
}
