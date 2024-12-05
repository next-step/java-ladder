package ladder.domain.factory;

import ladder.domain.engine.LadderCreator;
import ladder.domain.engine.LineGenerator;
import ladder.domain.nextstep.NextStepLadderCreator;
import ladder.domain.nextstep.RandomLineGenerator;

public class LadderFactoryBean {

    public static LadderCreator createLadderCreator() {
        LineGenerator lineGenerator = new RandomLineGenerator();
        return new NextStepLadderCreator(lineGenerator);
    }

}
