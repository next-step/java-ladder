package ladder.factory;

import ladder.engine.LadderCreator;
import ladder.engine.LineCreator;
import ladder.nextstep.NextStepLadderCreator;
import ladder.nextstep.NextStepLineCreator;

public class LadderFactoryBean {
    public static LadderCreator createLadderFactory() {
        LineCreator lineCreator = new NextStepLineCreator();
        return new NextStepLadderCreator(lineCreator);
    }
}
