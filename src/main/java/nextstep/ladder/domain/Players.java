package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Players extends FirstClassList<PlayerName> {
    private Players(final List<PlayerName> playerNames) {
        super(playerNames);
    }

    public static Players of(final List<String> names) {
        if (names == null) {
            throw new IllegalArgumentException("names cannot be null");
        }

        RailCount.validate(names.size());

        return new Players(names.stream()
                .map(PlayerName::of)
                .collect(Collectors.toList()));
    }

    @Override
    public String toString() {
        return "Players {" +
                super.toString() +
                '}';
    }
}
