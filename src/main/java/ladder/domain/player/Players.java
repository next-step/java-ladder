package ladder.domain.player;

import ladder.domain.Name;

import java.util.*;

public class Players implements Iterable<Player> {
    private final List<Player> players;

    public Players(List<Player> players) {
        validateOverlapPlayerNames(players);

        this.players = players;
    }

    private void validateOverlapPlayerNames(List<Player> players) {
        if (players.size() != new HashSet<>(players).size()) {
            throw new IllegalStateException("중복된 이름이 존재 합니다.");
        }
    }

    public Player get(int index) {
        return this.players.get(index);
    }

    public Optional<Player> findByName(Name name) {
        return players.stream()
                .filter(iPlayer -> iPlayer.checkName(name))
                .findFirst();
    }

    public int size() {
        return this.players.size();
    }

    @Override
    public Iterator<Player> iterator() {
        return players.iterator();
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Players players1 = (Players) o;
        return Objects.equals(players, players1.players);
    }
}