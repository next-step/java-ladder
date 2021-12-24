package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

import nextstep.ladder.engine.FirstClassList;
import nextstep.ladder.engine.Name;

public class Players extends FirstClassList<Name> implements nextstep.ladder.engine.Players {
    private Players(final List<Name> playerNames) {
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
