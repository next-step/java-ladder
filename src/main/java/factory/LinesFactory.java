package factory;

import engine.LinesCreator;
import nextstep.ladder.domain.NextStepLines;
import nextstep.ladder.strategy.LineStrategy;

public class LinesFactory {

    public static LinesCreator createNextStepLines(int size, int maxLadder, LineStrategy lineStrategy) {
        return new NextStepLines(size, maxLadder, lineStrategy);
    }

}
