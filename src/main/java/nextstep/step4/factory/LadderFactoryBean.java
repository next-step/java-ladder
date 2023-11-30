package nextstep.step4.factory;

import nextstep.step4.engine.LadderCreator;
import nextstep.step4.impl.SimpsonLadderCreator;
import nextstep.step4.impl.SimpsonLineCreator;

public class LadderFactoryBean {
    public static LadderCreator creatorLadderFactory() {
        return new SimpsonLadderCreator(new SimpsonLineCreator());
    }
}
