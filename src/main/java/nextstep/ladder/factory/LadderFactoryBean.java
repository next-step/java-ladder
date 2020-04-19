package nextstep.ladder.factory;

import nextstep.ladder.domain.DefaultLadderCreator;
import nextstep.ladder.engine.LadderCreator;

public class LadderFactoryBean {
    public static LadderCreator createLadderFactory(final int numberOfPlayers, final int height) {
        return new DefaultLadderCreator(numberOfPlayers, height);
    }
}
