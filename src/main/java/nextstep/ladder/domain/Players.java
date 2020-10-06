package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Players {

    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public int size() {
        return players.size();
    }

    public void move(Lines lines) {
        players.forEach(lines::move);
    }

    public Player find(String name) {
        return players.stream()
                .filter(player -> player.isSameName(name))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("존재하지 않는 플레이어입니다.")
                );
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players players1 = (Players) o;
        return players.equals(players1.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }
}
