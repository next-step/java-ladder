package factory;

import engine.LinesCreator;
import nextstep.ladder.domain.NextStepLines;
import nextstep.ladder.strategy.LineStrategy;

public class LinesFactoryBean {

    public static LinesCreator createNextStepLadderFactory(int size, int maxLadder, LineStrategy lineStrategy) {
        NextStepLines nextStepLines = new NextStepLines();
        nextStepLines.generateLine(size, maxLadder, lineStrategy);
        return new NextStepLines();
    }

}
