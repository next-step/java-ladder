package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import nextstep.ladder.domain.common.Name;
import nextstep.ladder.domain.common.Result;
import nextstep.ladder.domain.exception.NotExistsPlayerNameException;

public class LadderGame {

    private final Lines lines;
    private final List<Name> playerNames;
    private final List<Result> results;

    private LadderGame(final Lines lines, final List<Name> playerNames, final List<Result> results) {
        this.lines = lines;
        this.playerNames = playerNames;
        this.results = results;
    }

    public static LadderGame of(final Lines lines, final List<Name> playerNames, final List<Result> results) {
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

    public List<Name> getPlayerNames() {
        return Collections.unmodifiableList(playerNames);
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }
}
