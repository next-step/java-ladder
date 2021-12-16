package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Players extends FirstClassList<Player> {
    private Players(final List<Player> players) {
        super(players);
    }

    public static Players of(final List<String> names) {
        if (names == null) {
            throw new IllegalArgumentException("names cannot be null");
        }

        PlayerCount.validate(names.size());

        return new Players(names.stream()
                .map(Name::of)
                .map(Player::of)
                .collect(Collectors.toList()));
    }

    public PlayerCount count() {
        return PlayerCount.of(size());
    }

    @Override
    public String toString() {
        return "Players {" +
                super.toString() +
                '}';
    }
}
