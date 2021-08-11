package nextstep.ladder.domain;

import java.util.List;
import nextstep.ladder.domain.common.Name;
import nextstep.ladder.domain.common.Names;
import nextstep.ladder.domain.common.Result;
import nextstep.ladder.domain.common.Results;
import nextstep.ladder.domain.exception.NotExistsPlayerNameException;

public class LadderGame {

    private final HorizontalLines horizontalLines;
    private final Names playerNames;
    private final Results results;

    private LadderGame(final HorizontalLines horizontalLines, final Names playerNames, final Results results) {
        this.horizontalLines = horizontalLines;
        this.playerNames = playerNames;
        this.results = results;
    }

    public static LadderGame of(final HorizontalLines horizontalLines, final Names playerNames, final Results results) {
        return new LadderGame(horizontalLines, playerNames, results);
    }

    public Result getResult(final Name playerName) {
        playerNameValidation(playerName);

        final int index = playerNames.indexOf(playerName);
        final int goal = horizontalLines.goal(index);

        return results.get(goal);
    }

    private void playerNameValidation(final Name playerName) {
        if (!playerNames.contains(playerName)) {
            throw new NotExistsPlayerNameException();
        }
    }

    public List<HorizontalLine> getLines() {
        return horizontalLines.getValues();
    }

    public Names getPlayerNames() {
        return playerNames;
    }

    public Results getResults() {
        return results;
    }
}
