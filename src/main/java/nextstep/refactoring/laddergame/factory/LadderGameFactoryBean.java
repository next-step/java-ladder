package nextstep.refactoring.laddergame.factory;

import nextstep.refactoring.laddergame.concrete.LadderGameCreatorImpl;
import nextstep.refactoring.laddergame.engine.LadderGameCreator;

public class LadderGameFactoryBean {

    private LadderGameFactoryBean() {
    }

    public static LadderGameCreator ladderGameCreator() {
        return new LadderGameCreatorImpl();
    }

}
