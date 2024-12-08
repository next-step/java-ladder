package ladder.domain.factory;

import ladder.domain.engine.LadderCreator;
import ladder.domain.ns.NsLadderCreator;
import ladder.domain.ns.NsLinesCreator;
import ladder.domain.ns.NsLineCreator;

public class LadderFactory {
    public static LadderCreator createNsLadderCreator() {
        NsLineCreator nsLineCreator = new NsLineCreator();
        NsLinesCreator nsLinesCreator = new NsLinesCreator(nsLineCreator);
        return new NsLadderCreator(nsLinesCreator);
    }
}
