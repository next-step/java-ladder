package ladder.model;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Players {
    private final List<PlayerName> names;

    private Players(List<String> names) {
        this.names = names.stream()
                .map(PlayerName::new)
                .collect(toList());
    }

    static Players of(List<String> names) {
        return new Players(names);
    }

    List<String> getNames() {
        return names.stream()
                .map(PlayerName::getName)
                .collect(toList());
    }
}
