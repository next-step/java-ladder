package nextstep.ladder.domain.player;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {
    private List<Player> players;

    private Players(List<String> names) {
        validate(names);

        players = names.stream()
                .map(Player::from)
                .collect(Collectors.toList());
    }

    private void validate(List<String> names) {
        if (Objects.isNull(names)) {
            throw new IllegalArgumentException("Names can't be null");
        }
    }

    public static Players init(List<String> names) {
        return new Players(names);
    }

}
