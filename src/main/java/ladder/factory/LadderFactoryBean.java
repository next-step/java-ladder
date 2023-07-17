package ladder.factory;

import ladder.domain.JerryLadderCreator;
import ladder.domain.JerryLineCreator;
import ladder.engine.LadderCreator;
import ladder.engine.LineCreator;

public class LadderFactoryBean {
    public static LadderCreator createLadderFactory() {
        LineCreator lineCreator = new JerryLineCreator();
        return new JerryLadderCreator(lineCreator);
    }
}
