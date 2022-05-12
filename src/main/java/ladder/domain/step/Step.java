package ladder.domain.step;

import ladder.domain.step.strategy.CrossStrategy;
import ladder.domain.step.strategy.RandomCrossStrategy;

public class Step {
    private final CrossStrategy crossStrategy;

    public Step() {
        this(new RandomCrossStrategy());
    }

    public Step(CrossStrategy crossStrategy) {
        validate(crossStrategy);
        this.crossStrategy = crossStrategy;
    }

    private void validate(CrossStrategy crossStrategy) {
        if (crossStrategy == null) {
            throw new IllegalArgumentException("crossStrategy는 null 일 수 없습니다.");
        }
    }

    public boolean isCrossable() {
        return crossStrategy.isCrossable();
    }
}
