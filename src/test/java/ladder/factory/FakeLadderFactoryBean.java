package ladder.factory;

import ladder.core.DirectionGenerator;

public class FakeLadderFactoryBean extends LadderFactoryBean {
    private final DirectionGenerator directionGenerator;

    public FakeLadderFactoryBean(final DirectionGenerator directionGenerator) {
        this.directionGenerator = directionGenerator;
    }

    public void changeInstance() {
        LadderFactoryBean.setInstance(this);
    }

    @Override
    public DirectionGenerator directionGenerator() {
        return directionGenerator;
    }
}