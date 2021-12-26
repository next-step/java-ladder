package ladderinterface.factory;

import ladderinterface.concrete.LadderLineCreator;
import ladderinterface.concrete.StepLadderCreator;
import ladderinterface.engine.LadderCreator;
import ladderinterface.engine.LineCreator;
import ladderinterface.util.RandomGenerator;

public class LadderFactoryBean {

    public static LadderCreator createLadderFactory() {
        LineCreator lineCreator = new LadderLineCreator(new RandomGenerator());
        return new StepLadderCreator(lineCreator);
    }

}
