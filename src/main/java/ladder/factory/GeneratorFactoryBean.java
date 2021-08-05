package ladder.factory;

import ladder.core.DirectionGenerator;
import ladder.core.LadderLineGenerator;
import ladder.domain.line.BasicLadderLineGenerator;
import ladder.domain.point.UnconnectedRandomDirectionGenerator;

import java.util.Objects;

public class GeneratorFactoryBean {
    protected GeneratorFactoryBean() {}

    public static GeneratorFactoryBean getInstance() {
        return InnerLazyClass.instance;
    }

    public synchronized static void setInstance(GeneratorFactoryBean ladderFactoryBean) {
        if (Objects.isNull(ladderFactoryBean))
            throw new NullPointerException();

        InnerLazyClass.instance = ladderFactoryBean;
    }

    public DirectionGenerator directionGenerator() {
        return InnerLazyClass.DIRECTION_GENERATOR;
    }

    public LadderLineGenerator ladderLineGenerator() {
        return InnerLazyClass.LADDER_LINE_GENERATOR;
    }

    private static class InnerLazyClass {
        private static GeneratorFactoryBean instance = new GeneratorFactoryBean();

        private static final DirectionGenerator DIRECTION_GENERATOR = new UnconnectedRandomDirectionGenerator();
        private static final LadderLineGenerator LADDER_LINE_GENERATOR = new BasicLadderLineGenerator();
    }
}
