package refactoring.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private final List<Name> players;

    private Players(String[] names) {
        this.players = Arrays.stream(names).map(Name::new).collect(Collectors.toList());
    }

    public static Players of(final String[] names) {
        return new Players(names);
    }

    public int size() {
        return players.size();
    }

    public List<Name> getNames() {
        return players;
    }
}
