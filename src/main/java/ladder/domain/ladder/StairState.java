package ladder.domain.ladder;

import ladder.domain.ladder.strategy.StairGenerationStrategy;

public class StairState {

    private final boolean existLine;

    private StairState(final boolean existLine) {
        this.existLine = existLine;
    }

    public static StairState ofFirstPillar(final StairGenerationStrategy strategy) {
        return new StairState(strategy.generate());
    }

    public StairState ofMiddlePillar(final StairGenerationStrategy strategy) {
        if (isExistLine()) {
            return ofWithNoLine();
        }
        return new StairState(strategy.generate());
    }

    public StairState ofWithNoLine() {
        return new StairState(false);
    }

    public boolean isExistLine() {
        return existLine;
    }
}
