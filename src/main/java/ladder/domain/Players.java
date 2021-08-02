package ladder.domain;

import ladder.exception.DuplicateKeyException;
import ladder.view.DosInputView;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

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
}
