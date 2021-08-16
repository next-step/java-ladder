package ladder.model;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Players {
    private final List<PlayerName> names;

    public Players(List<String> names) {
        this.names = names.stream()
                .map(PlayerName::new)
                .collect(toList());
    }

    public int count() {
        return names.size();
    }

    List<String> getNames() {
        return names.stream()
                .map(PlayerName::getName)
                .collect(toList());
    }
}
