package nextstep.ladder.domain;

import nextstep.ladder.domain.edge.LadderEdges;
import nextstep.ladder.domain.line.Height;
import nextstep.ladder.domain.line.LineFactory;
import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.dto.LadderDto;

public class Ladder {
    private final Lines lines;
    private final LadderEdges ladderEdges;

    public Ladder(LadderEdges ladderEdges, int height) {
        this(ladderEdges, new Height(height), new LineFactory());
    }

    public Ladder(LadderEdges ladderEdges, Height height, LineFactory lineFactory) {
        this.ladderEdges = ladderEdges;
        this.lines = new Lines(ladderEdges.userSize(), height, lineFactory);
    }



    public LadderDto toLadderResult() {
        return new LadderDto(ladderEdges.getLadderUserNames(), lines.getvalue());
    }
}
