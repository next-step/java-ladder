package ladder.domain;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public int move(String name, Ladder ladder) {
        int index = players.indexOf(new Player(name));
        if (index == -1) {
            throw new IllegalArgumentException();
        }

        return ladder.move(index);
    }

    public int size() {
        return this.players.size();
    }

    public List<String> getPlayersNames() {
        return players.stream()
                .map(player -> player.getName())
                .collect(Collectors.toList());
    }

    public int getMaxNameLength() {
        return players.stream()
                .mapToInt(player -> player.getName().length())
                .max()
                .orElseThrow(NoSuchElementException::new);
    }
}
