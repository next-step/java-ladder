package nextstep.ladder.factory;

import nextstep.ladder.codeleesh.domain.CodeLadderCreator;
import nextstep.ladder.codeleesh.domain.CodeLineCreator;
import nextstep.ladder.engine.LadderCreator;
import nextstep.ladder.engine.LineCreator;

public class LadderFactoryBean {

    private LadderFactoryBean() {}

    public static LadderCreator createLadderFactory() {

        final LineCreator lineCreator = new CodeLineCreator();
        return new CodeLadderCreator(lineCreator);
    }
}
