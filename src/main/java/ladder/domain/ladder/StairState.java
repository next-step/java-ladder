package ladder.domain.ladder;

import ladder.domain.ladder.strategy.StairGenerationStrategy;

public class StairState {

    private final boolean existLine;

    private StairState(final boolean existLine) {
        this.existLine = existLine;
    }

    public static StairState ofFirstPillar(final StairGenerationStrategy strategy) {
        return new StairState(strategy.isGeneratable());
    }

    public StairState ofMiddlePillar(final StairGenerationStrategy strategy) {
        return new StairState(strategy.isGeneratable());
    }

    public StairState ofMiddlePillarWithNoLine() {
        return new StairState(false);
    }

    public boolean isExistLine() {
        return existLine;
    }
}
