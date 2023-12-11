package ladder.factory;

import ladder.engine.LadderGenerator;
import ladder.engine.LineGenerator;
import ladder.gilbert.*;

public class LadderFactoryBean {


    public static LadderGenerator createLadderFactory() {
        BooleanGenerator booleanGenerator = new GilbertRandomBooleanGenerator();
        LineGenerator lineGenerator = new GilbertLineGenerator(booleanGenerator);
        return new GilbertLadderGenerator(lineGenerator);
    }

}
