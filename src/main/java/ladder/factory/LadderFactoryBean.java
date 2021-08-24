package ladder.factory;

import ladder.domain.engine.LadderCreator;
import ladder.domain.engine.LineCreator;
import ladder.domain.engine.PointCreator;
import ladder.domain.impl.MyLadderCreator;
import ladder.domain.impl.MyLineCreator;
import ladder.domain.impl.MyPointCreator;

public class LadderFactoryBean {

    private LadderFactoryBean() {
    }

    public static PointCreator pointCreator() {
        return new MyPointCreator();
    }

    public static LineCreator lineCreator() {
        return new MyLineCreator(pointCreator());
    }

    public static LadderCreator ladderCreator() {
        return new MyLadderCreator(lineCreator());
    }
}
