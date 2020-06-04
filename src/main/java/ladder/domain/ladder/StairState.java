package ladder.domain.ladder;

import ladder.domain.ladder.strategy.StairGenerationStrategy;

import java.util.Objects;

public class StairState {

    private final boolean isExistLine;

    private StairState(final boolean isExistLine) {
        this.isExistLine = isExistLine;
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
        return isExistLine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StairState)) return false;
        StairState that = (StairState) o;
        return isExistLine == that.isExistLine;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isExistLine);
    }
}
