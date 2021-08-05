package ladder.factory;

import ladder.core.DirectionGenerator;
import ladder.domain.direction.UnconnectedRandomDirectionGenerator;

import java.util.Objects;

public class LadderFactoryBean {
    protected LadderFactoryBean() {}

    public static LadderFactoryBean getInstance() {
        return InnerLazyClass.instance;
    }

    public static void setInstance(LadderFactoryBean ladderFactoryBean) {
        if (Objects.isNull(ladderFactoryBean))
            throw new NullPointerException();

        InnerLazyClass.instance = ladderFactoryBean;
    }

    public DirectionGenerator directionGenerator() {
        return InnerLazyClass.DIRECTION_GENERATOR;
    }

    private static class InnerLazyClass {
        private static final DirectionGenerator DIRECTION_GENERATOR = new UnconnectedRandomDirectionGenerator();

        private static LadderFactoryBean instance = new LadderFactoryBean();
    }
}
