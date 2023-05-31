package nextstep.ladder.domain.factory;

import nextstep.ladder.domain.engine.LadderCreator;
import nextstep.ladder.domain.engine.LineCreator;
import nextstep.ladder.domain.nextstep.NextStepLadderCreator;
import nextstep.ladder.domain.nextstep.NextStepLineCreator;

public class LadderFactoryBean {
    public static LadderCreator createLadderFactory() {
        LineCreator lineCreator = new NextStepLineCreator();
        return new NextStepLadderCreator(lineCreator);
    }
}
