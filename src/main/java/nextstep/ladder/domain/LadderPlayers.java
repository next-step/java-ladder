package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

import nextstep.ladder.engine.FirstClassList;
import nextstep.ladder.engine.Name;
import nextstep.ladder.engine.Players;

public class LadderPlayers extends FirstClassList<Name> implements Players {
    private LadderPlayers(final List<Name> playerNames) {
        super(playerNames);
    }

    public static LadderPlayers of(final List<String> names) {
        if (names == null) {
            throw new IllegalArgumentException("names cannot be null");
        }

        RailCount.validate(names.size());

        return new LadderPlayers(names.stream()
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
