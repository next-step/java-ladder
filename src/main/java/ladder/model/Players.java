package ladder.model;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Players {
    private final List<PlayerName> names;

    public Players(List<String> names) {
        validateNotEmpty(names);
        this.names = names.stream()
                .map(PlayerName::new)
                .collect(toList());
    }

    private void validateNotEmpty(List<String> names) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException("게임 참가자가 없습니다.");
        }
    }

    public int count() {
        return names.size();
    }

    public List<String> getNames() {
        return names.stream()
                .map(PlayerName::getName)
                .collect(toList());
    }
}
