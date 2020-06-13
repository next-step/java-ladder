package ladder.domain.ladder;

import ladder.domain.ladder.shape.PillarCount;
import ladder.domain.ladder.strategy.StairGenerationStrategy;

import java.util.List;

public class RowPillars {

    private final Stairs stairs;

    private RowPillars(final Stairs stairs) {
        this.stairs = stairs;
    }

    public static RowPillars of(final PillarCount pillarCount, final StairGenerationStrategy strategy) {
        return new RowPillars(Stairs.of(pillarCount, strategy));
    }

    public List<Stair> getStairs() {
        return stairs.getStairs();
    }

    public int getWidth() {
        return stairs.getWidth();
    }

    public Position nextPosition(final Position position) {
        return stairs.move(position);
    }
}
