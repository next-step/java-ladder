package ladder.factory;

import ladder.core.DirectionGenerator;
import ladder.core.LadderLineGenerator;

public class FakeGeneratorFactoryBean extends GeneratorFactoryBean {
    private final DirectionGenerator directionGenerator;
    private final LadderLineGenerator ladderLineGenerator;

    public FakeGeneratorFactoryBean(final DirectionGenerator directionGenerator,
                                    final LadderLineGenerator ladderLineGenerator) {
        this.directionGenerator = directionGenerator;
        this.ladderLineGenerator = ladderLineGenerator;
    }

    public void changeInstance() {
        GeneratorFactoryBean.setInstance(this);
    }

    @Override
    public DirectionGenerator directionGenerator() {
        return directionGenerator;
    }

    @Override
    public LadderLineGenerator ladderLineGenerator() {
        return ladderLineGenerator;
    }
}