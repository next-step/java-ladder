package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private static final String SEPARATOR = ",";
    private final List<Name> players;

    public Player(String names) {
        players = Arrays.stream(names.split(SEPARATOR))
            .map(String::trim)
            .map(Name::new)
            .collect(Collectors.toList());
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(players);
    }
}
