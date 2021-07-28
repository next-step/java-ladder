package nextstep.ladder.domain.init;

import nextstep.ladder.domain.player.Players;
import nextstep.ladder.domain.result.Results;

public class PlayersAndResults {
    private final Players players;
    private final Results results;

    private PlayersAndResults(Players players, Results results) {
        this.players = players;
        this.results = results;
    }

    public static PlayersAndResults of(Players players, Results results) {
        return new PlayersAndResults(players, results);
    }
}
