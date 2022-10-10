package ladder.view;

import ladder.domain.LadderResults;
import ladder.domain.Names;

public class InputDto {
    private final Names names;
    private final Integer height;
    private final LadderResults ladderResults;

    public InputDto(Names names, Integer height, LadderResults ladderResults) {
        this.names = names;
        this.height = height;
        this.ladderResults = ladderResults;
    }

    public Names getNames() {
        return names;
    }

    public Integer getHeight() {
        return height;
    }

    public LadderResults getLadderResults() {
        return ladderResults;
    }
}
