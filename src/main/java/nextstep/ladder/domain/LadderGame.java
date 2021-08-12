package nextstep.ladder.domain;

import java.util.List;
import nextstep.ladder.domain.common.GameResults;
import nextstep.ladder.domain.common.Player;
import nextstep.ladder.domain.common.Players;
import nextstep.ladder.domain.common.Result;
import nextstep.ladder.domain.common.exception.NotExistsPlayerNameException;

public class LadderGame {

    private final HorizontalLines horizontalLines;
    private final Players players;
    private final GameResults gameResults;

    private LadderGame(final HorizontalLines horizontalLines, final Players players, final GameResults gameResults) {
        this.horizontalLines = horizontalLines;
        this.players = players;
        this.gameResults = gameResults;

        this.players.getValues().forEach(player -> player.updateResult(getResult(player)));
    }

    public static LadderGame of(final HorizontalLines horizontalLines, final Players players, final GameResults gameResults) {
        return new LadderGame(horizontalLines, players, gameResults);
    }

    private Result getResult(final Player player) {
        playerNameValidation(player);

        final int index = players.indexOf(player);
        final int goal = horizontalLines.goal(index);

        return gameResults.get(goal);
    }

    private void playerNameValidation(final Player player) {
        if (!players.contains(player)) {
            throw new NotExistsPlayerNameException();
        }
    }

    public List<HorizontalLine> getLines() {
        return horizontalLines.getValues();
    }

    public Players getPlayers() {
        return players;
    }

    public GameResults getResults() {
        return gameResults;
    }
}
