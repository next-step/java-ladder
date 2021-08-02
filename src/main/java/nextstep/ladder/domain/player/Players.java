package nextstep.ladder.domain.player;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    private Players(List<String> names) {
        validate(names);
        players = names.stream().map(Player::of).collect(Collectors.toList());
    }

    private void validate(List<String> names) {
        if (Objects.isNull(names) || names.isEmpty()) {
            throw new IllegalArgumentException("이름 List는 null이거나 비어있으면 안됩니다.");
        }
    }

    public static Players of(List<String> names) {
        return new Players(names);
    }

    public List<String> getNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }
}
