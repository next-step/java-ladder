package ladder.domain;

import ladder.exception.DuplicateKeyException;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Players implements Iterable<Player> {
    private final List<Player> players;

    public Players(List<Player> players) {
        validateOverlapPlayerNames(players);

        this.players = players;
    }

    private void validateOverlapPlayerNames(List<Player> players) {
        if (players.size() != new HashSet<>(players).size()) {
            throw new DuplicateKeyException("중복된 이름이 존재 합니다.");
        }
    }

    @Override
    public Iterator<Player> iterator() {
        return players.iterator();
    }

    public int size() {
        return players.size();
    }

    @Override
    public boolean equals(Object compareValue) {
        if (this == compareValue) return true;
        if (compareValue == null || getClass() != compareValue.getClass()) return false;
        Players players1 = (Players) compareValue;
        return Objects.equals(players, players1.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }
}
