package nextstep.ladder.dto;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Lines;

import java.util.Collections;
import java.util.List;

public class LadderResultDto {
    private final List<String> playerNames;
    private final Lines lines;
    private final List<String> scores;

    public LadderResultDto(List<String> playerNames, Lines lines, List<String> scores) {
        this.playerNames = Collections.unmodifiableList(playerNames);
        this.lines = lines;
        this.scores = Collections.unmodifiableList(scores);
    }

    public List<String> getPlayerNames() {
        return this.playerNames;
    }

    public List<Line> getLines() {
        return this.lines.getLines();
    }

    public List<String> getScores() {
        return this.scores;
    }
}
