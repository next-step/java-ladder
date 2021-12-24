package ladderinterface.factory;

import ladderinterface.concrete.LadderLineCreator;
import ladderinterface.concrete.StepLadderCreator;
import ladderinterface.engine.LadderCreator;
import ladderinterface.engine.LineCreator;

public class LadderFactoryBean {

    public static LadderCreator createLadderFactory() {
        LineCreator lineCreator = new LadderLineCreator();
        return new StepLadderCreator(lineCreator);
    }

}
