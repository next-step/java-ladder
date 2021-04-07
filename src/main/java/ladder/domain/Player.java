package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private static final String SEPARATOR = ",";

    private final List<PlayerName> players;

    public Player(String names) {
        players = Arrays.stream(names.split(SEPARATOR))
            .map(PlayerName::new)
            .collect(Collectors.toList());
    }

    public List<PlayerName> getNames() {
        return Collections.unmodifiableList(players);
    }
}
