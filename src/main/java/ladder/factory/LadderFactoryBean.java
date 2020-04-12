package ladder.factory;

import ladder.engine.LadderRepository;
import ladder.engine.LineRepository;
import ladder.nextstep.NextStepLadderRepository;
import ladder.nextstep.NextStepLineRepository;

public class LadderFactoryBean {
    public static LadderRepository createLadderFactory() {
        LineRepository lineRepository = new NextStepLineRepository();
        return new NextStepLadderRepository(lineRepository);
    }
}
