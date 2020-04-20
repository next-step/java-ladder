package nextstep.ladder.factory;

import nextstep.ladder.domain.DefaultLadderCreator;
import nextstep.ladder.engine.LadderCreator;

public class LadderFactoryBean {
    public static LadderCreator createLadderFactory(final int width, final int height) {
        return new DefaultLadderCreator(width, height);
    }
}
