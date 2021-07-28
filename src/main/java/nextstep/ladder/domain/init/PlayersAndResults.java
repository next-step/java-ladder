package nextstep.ladder.domain.init;

import nextstep.ladder.domain.player.Players;
import nextstep.ladder.domain.result.Results;
import nextstep.ladder.exception.NullArgumentException;

import java.util.Objects;

public class PlayersAndResults {
    private final Players players;
    private final Results results;

    private PlayersAndResults(Players players, Results results) {
        validate(players, results);
        this.players = players;
        this.results = results;
    }

    private void validate(Players players, Results results) {
        if (Objects.isNull(players)) {
            throw new NullArgumentException(Players.class);
        }

        if (Objects.isNull(results)) {
            throw new NullArgumentException(Results.class);
        }
    }

    public static PlayersAndResults of(Players players, Results results) {
        return new PlayersAndResults(players, results);
    }
}
