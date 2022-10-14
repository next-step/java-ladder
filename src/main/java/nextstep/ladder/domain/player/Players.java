package nextstep.ladder.domain.player;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> values;

    public static Players create(String names) {
        return create(Names.of(names));
    }

    public static Players create(Names names) {
        List<Player> players = names.values()
                .stream()
                .map(Player::new)
                .collect(Collectors.toList());

        return new Players(players);
    }

    public Players(List<Player> values) {
        this.values = values.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public int count() {
        return values.size();
    }

    public List<Player> values() {
        return Collections.unmodifiableList(values);
    }
}
