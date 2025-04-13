package nextstep.ladder.domain;

import nextstep.ladder.domain.edge.LadderEdge;
import nextstep.ladder.domain.line.Height;
import nextstep.ladder.domain.line.LineFactory;
import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.user.LadderUsers;
import nextstep.ladder.dto.LadderDto;

import java.util.List;

public class Ladder {
    private final Lines lines;
    private final LadderEdge ladderEdge;

    public Ladder(LadderEdge ladderEdge, int height) {
        this(ladderEdge, new Height(height), new LineFactory());
    }

    public Ladder(LadderEdge ladderEdge, int height, LineFactory lineFactory) {
        this(ladderEdge, new Height(height), lineFactory);
    }

    public Ladder(LadderEdge ladderEdge, Height height, LineFactory lineFactory) {
        this.ladderEdge = ladderEdge;
        this.lines = new Lines(ladderEdge.userSize(), height, lineFactory);
    }

    public LadderDto toLadderResult() {
        return new LadderDto(ladderEdge.getLadderUserNames(), lines.getvalue());
    }
}
