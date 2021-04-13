package ladder.domain.factory;

import ladder.domain.engine.LadderGenerator;
import ladder.domain.engine.LineGenerator;
import ladder.domain.nextstep.NextStepLadderGenerator;
import ladder.domain.nextstep.NextStepLineGenerator;

public class LadderFactoryBean {
    public static LadderGenerator LadderFactory() {
        LineGenerator linegenerator = new NextStepLineGenerator();
        return new NextStepLadderGenerator(linegenerator);
    }
}
