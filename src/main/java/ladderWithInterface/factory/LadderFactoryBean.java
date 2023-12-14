package ladderWithInterface.factory;

import ladderWithInterface.custom.CustomLadderCreator;
import ladderWithInterface.custom.CustomLineCreator;
import ladderWithInterface.engin.LadderCreator;
import ladderWithInterface.engin.LineCreator;

public class LadderFactoryBean {
    public static LadderCreator createLadderFactory() {
        LineCreator lineCreator = new CustomLineCreator();
        return new CustomLadderCreator(lineCreator);
    }
}
