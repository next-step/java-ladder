package nextstep.ladder.domain;

import nextstep.ladder.domain.common.Name;
import nextstep.ladder.domain.common.Names;
import nextstep.ladder.domain.common.Result;
import nextstep.ladder.domain.common.Results;
import nextstep.ladder.domain.exception.NotExistsPlayerNameException;

public class LadderGame {

    private final Lines lines;
    private final Names playerNames;
    private final Results results;

    private LadderGame(final Lines lines, final Names playerNames, final Results results) {
        this.lines = lines;
        this.playerNames = playerNames;
        this.results = results;
    }

    public static LadderGame of(final Lines lines, final Names playerNames, final Results results) {
        return new LadderGame(lines, playerNames, results);
    }

    public Result getResult(final Name playerName) {
        playerNameValidation(playerName);

        final int index = playerNames.indexOf(playerName);
        final int goal = lines.goal(index);

        return results.get(goal);
    }

    private void playerNameValidation(final Name playerName) {
        if (!playerNames.contains(playerName)) {
            throw new NotExistsPlayerNameException();
        }
    }

    public Lines getLines() {
        return lines;
    }

    public Names getPlayerNames() {
        return playerNames;
    }

    public Results getResults() {
        return results;
    }
}
