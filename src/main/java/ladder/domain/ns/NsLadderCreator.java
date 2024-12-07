package ladder.domain.ns;

import ladder.domain.engine.Ladder;
import ladder.domain.engine.LadderCreator;
import ladder.domain.engine.Lines;
import ladder.domain.engine.Players;

public class NsLadderCreator implements LadderCreator {
    private final NsLinesCreator nsLinesCreator;

    public NsLadderCreator(NsLinesCreator nsLinesCreator) {
        this.nsLinesCreator = nsLinesCreator;
    }

    @Override
    public Ladder create(Players players, int verticalHeight) {
        Lines lines = nsLinesCreator.create(players, verticalHeight);
        return new NsLadder(players, lines);
    }
}
