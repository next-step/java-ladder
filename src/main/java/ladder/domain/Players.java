package ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {
    private final List<Player> players;

    Players(List<String> names) {
        this.players = names.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    List<Player> getPlayers() {
        return players;
    }

    int index(Player player) {
        return IntStream.range(0, players.size())
                .filter(i -> players.get(i).equals(player))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 player를 찾을 수 없습니다."));
    }

    int size() {
        return players.size();
    }

    Player get(int index) {
        return players.get(index);
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
