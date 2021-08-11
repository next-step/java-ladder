package nextstep.ladder.domain;

import java.util.List;
import nextstep.ladder.domain.common.Name;
import nextstep.ladder.domain.common.Player;
import nextstep.ladder.domain.common.Players;
import nextstep.ladder.domain.common.Result;
import nextstep.ladder.domain.common.Results;
import nextstep.ladder.domain.common.exception.NotExistsPlayerNameException;

public class LadderGame {

    private final HorizontalLines horizontalLines;
    private final Players players;
    private final Results results;

    private LadderGame(final HorizontalLines horizontalLines, final Players players, final Results results) {
        this.horizontalLines = horizontalLines;
        this.players = players;
        this.results = results;

        this.players.getValues().forEach(player -> player.updateResult(getResult(player)));
    }

    public static LadderGame of(final HorizontalLines horizontalLines, final Players players, final Results results) {
        return new LadderGame(horizontalLines, players, results);
    }

    private Result getResult(final Player player) {
        playerNameValidation(player);

        final int index = players.indexOf(player);
        final int goal = horizontalLines.goal(index);

        return results.get(goal);
    }

    private void playerNameValidation(final Player player) {
        if (!players.contains(player)) {
            throw new NotExistsPlayerNameException();
        }
    }

    public List<HorizontalLine> getLines() {
        return horizontalLines.getValues();
    }

    public Players getPlayer(final Name name) {
        return players;
    }

    public Players getPlayers() {
        return players;
    }

    public Results getResults() {
        return results;
    }
}
