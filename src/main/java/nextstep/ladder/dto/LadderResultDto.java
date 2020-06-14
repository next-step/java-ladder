package nextstep.ladder.dto;

import nextstep.ladder.domain.LadderLine;
import nextstep.ladder.domain.LadderLines;

import java.util.Collections;
import java.util.List;

public class LadderResultDto {
    private final List<String> playerNames;
    private final LadderLines ladderLines;
    private final List<String> scores;

    public LadderResultDto(List<String> playerNames, LadderLines ladderLines, List<String> scores) {
        this.playerNames = Collections.unmodifiableList(playerNames);
        this.ladderLines = ladderLines;
        this.scores = Collections.unmodifiableList(scores);
    }

    public List<String> getPlayerNames() {
        return this.playerNames;
    }

    public List<LadderLine> getLadderLines() {
        return this.ladderLines.getLadderLines();
    }

    public List<String> getScores() {
        return this.scores;
    }
}
