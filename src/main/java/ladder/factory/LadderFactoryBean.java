package ladder.factory;

import ladder.core.DirectionGenerator;
import ladder.domain.direction.UnconnectedRandomDirectionGenerator;

public final class LadderFactoryBean {
    public static DirectionGenerator directionGenerator() {
        return InnerLazyClass.DIRECTION_GENERATOR;
    }

    private static class InnerLazyClass {
        private static final DirectionGenerator DIRECTION_GENERATOR = new UnconnectedRandomDirectionGenerator();
    }
}
