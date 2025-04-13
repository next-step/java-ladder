package nextstep.ladder.domain;

import nextstep.ladder.domain.edge.LadderConfig;
import nextstep.ladder.domain.line.Height;
import nextstep.ladder.domain.line.LineFactory;
import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.dto.LadderDto;

public class Ladder {
    private final Lines lines;
    private final LadderConfig ladderConfig;

    public Ladder(LadderConfig ladderConfig, Height height, LineFactory lineFactory) {
        this.ladderConfig = ladderConfig;
        this.lines = new Lines(ladderConfig.size(), height, lineFactory);
    }

    public LadderDto toLadderDto() {
        return new LadderDto(
            ladderConfig.getUsersName(),
            lines.getvalue(),
            ladderConfig.getPrizesValue(),
            ladderConfig.getResultString(lines)
        );
    }
}
