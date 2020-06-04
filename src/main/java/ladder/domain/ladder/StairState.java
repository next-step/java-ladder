package ladder.domain.ladder;

import ladder.domain.ladder.strategy.StairGenerationStrategy;

import java.util.Objects;

public class StairState {

    private final boolean existLine;

    private StairState(final boolean existLine) {
        this.existLine = existLine;
    }

    public static StairState ofFirstPillar(final StairGenerationStrategy strategy) {
        return new StairState(strategy.generate());
    }

    public StairState ofNextPillar(final StairGenerationStrategy strategy) {
        if (isExistLine()) {
            return ofNextPillarWithNoLine();
        }
        return new StairState(strategy.generate());
    }

    public StairState ofNextPillarWithNoLine() {
        return new StairState(false);
    }

    public boolean isExistLine() {
        return existLine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StairState)) return false;
        StairState that = (StairState) o;
        return existLine == that.existLine;
    }

    @Override
    public int hashCode() {
        return Objects.hash(existLine);
    }
}
