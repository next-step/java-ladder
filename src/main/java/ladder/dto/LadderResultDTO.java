package ladder.dto;

import ladder.domain.LadderLine;

import java.util.List;

public class LadderResultDTO {
    private final List<String> userNames;
    private final List<LadderLine> ladderLine;

    public LadderResultDTO(final List<String> userNames, final List<LadderLine> ladderLine) {
        this.userNames = userNames;
        this.ladderLine = ladderLine;
    }

    public List<String> getUserNames() {
        return userNames;
    }

    public List<LadderLine> getLadderLine() {
        return ladderLine;
    }
}
