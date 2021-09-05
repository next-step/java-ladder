package ladder.model;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Players {
    private final List<Player> players;

    public Players(List<String> names) {
        validateNotEmpty(names);
        this.players = names.stream()
                .map(Player::new)
                .collect(toList());
    }

    private void validateNotEmpty(List<String> names) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException("게임 참가자가 없습니다.");
        }
    }

    public int count() {
        return players.size();
    }

    public List<String> getNames() {
        return players.stream()
                .map(Player::getName)
                .collect(toList());
    }

    int findIndex(Player name) {
        return players.indexOf(name);
    }
}
