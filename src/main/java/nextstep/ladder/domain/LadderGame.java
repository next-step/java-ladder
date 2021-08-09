package nextstep.ladder.domain;

import java.util.List;
import nextstep.ladder.domain.common.Name;
import nextstep.ladder.domain.common.Result;

public class LadderGame {

    private final Lines lines;
    private final List<Name> playerNames;
    private final List<Result> results;

    private LadderGame(final Lines lines, final List<Name> playerNames, final List<Result> results) {
        this.lines = lines;
        this.playerNames = playerNames;
        this.results = results;
    }

    public LadderGame of(final Lines lines, final List<Name> playerNames, final List<Result> results) {
        return new LadderGame(lines, playerNames, results);
    }

    public Result play(final Name playerName) {
        final int index = playerNames.indexOf(playerName);
        return null;
    }
}
