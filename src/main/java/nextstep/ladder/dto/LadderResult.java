package nextstep.ladder.dto;

import nextstep.ladder.domain.init.PlayersAndResults;
import nextstep.ladder.domain.ladder.Ladder;

import java.util.List;

public class LadderResult {
    private final List<String> names;
    private final List<RowDto> rows;
    private final List<String> results;

    private LadderResult(List<String> names, List<RowDto> rows, List<String> results) {
        this.names = names;
        this.rows = rows;
        this.results = results;
    }

    public static LadderResult of(PlayersAndResults playersAndResults, Ladder ladder) {
        return new LadderResult(
                playersAndResults.getPlayers().getNames(),
                ladder.getSteps(),
                playersAndResults.getResults().getResults()
        );
    }

    public List<String> getNames() {
        return names;
    }

    public List<RowDto> getRows() {
        return rows;
    }

    public List<String> getResults() {
        return results;
    }
}
