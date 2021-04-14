package nextstep.refactoring.ladder.factory;

import nextstep.refactoring.ladder.concrete.LadderCreatorImpl;
import nextstep.refactoring.ladder.concrete.LineCreatorImpl;
import nextstep.refactoring.ladder.engine.LadderCreator;
import nextstep.refactoring.ladder.engine.LineCreator;

public class LadderFactoryBean {

    private LadderFactoryBean() {}

    public static LadderCreator ladderCreator() {
        LineCreator lineCreator = new LineCreatorImpl();
        return new LadderCreatorImpl(lineCreator);
    }

}
