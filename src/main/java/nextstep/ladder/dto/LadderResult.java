package nextstep.ladder.dto;

import nextstep.ladder.domain.init.PlayersAndGifts;
import nextstep.ladder.domain.ladder.Ladder;

import java.util.List;

public class LadderResult {
    private final List<String> names;
    private final List<RowDto> rows;
    private final List<String> gifts;

    private LadderResult(List<String> names, List<RowDto> rows, List<String> gifts) {
        this.names = names;
        this.rows = rows;
        this.gifts = gifts;
    }

    public static LadderResult of(PlayersAndGifts playersAndGifts, Ladder ladder) {
        return new LadderResult(
                playersAndGifts.getPlayers().getNames(),
                ladder.getSteps(),
                playersAndGifts.getGifts().getGifts()
        );
    }

    public List<String> getNames() {
        return names;
    }

    public List<RowDto> getRows() {
        return rows;
    }

    public List<String> getGifts() {
        return gifts;
    }
}
