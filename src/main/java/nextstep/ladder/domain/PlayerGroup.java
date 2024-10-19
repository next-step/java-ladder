package nextstep.ladder.domain;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class PlayerGroup {

    private static final String DELIMITER = ",";

    private final List<Player> players;

    public PlayerGroup(String playerStrings) {
        this(toList(playerStrings));
    }

    private static List<String> toList(String playerStrings) {
        return List.of(Optional.ofNullable(playerStrings)
                        .filter(string -> !string.isBlank())
                        .orElseThrow(() -> new IllegalArgumentException("문자열에 공백 또는 null은 허용되지 않습니다."))
                        .split(DELIMITER));
    }

    public PlayerGroup(List<String> playerNames) {
        this.players = playerNames.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public Collection<String> playerNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    public int count() {
        return players.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlayerGroup that = (PlayerGroup) o;
        return Objects.equals(players, that.players);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(players);
    }
}
