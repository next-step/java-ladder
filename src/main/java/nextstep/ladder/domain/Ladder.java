package nextstep.ladder.domain;

import nextstep.ladder.domain.edge.LadderConfig;
import nextstep.ladder.domain.edge.LadderPrizes;
import nextstep.ladder.domain.edge.LadderResult;
import nextstep.ladder.domain.edge.LadderUsers;
import nextstep.ladder.domain.line.Height;
import nextstep.ladder.domain.line.LineFactory;
import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.dto.LadderDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ladder {
    private final Lines lines;
    private final LadderConfig ladderConfig;

    public Ladder(LadderUsers users, LadderPrizes prizes, int height) {
        this(new LadderConfig(users, prizes), new Height(height), new LineFactory());
    }

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
