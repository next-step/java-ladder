package ladder.domain.ladder;

import ladder.domain.ladder.strategy.RandomStairGenerationStrategy;
import ladder.exception.ErrorMessage;

import java.util.Objects;

public class Stair {

    private final StairState stairState;

    private Stair(final StairState stairState) {
        validate(stairState);
        this.stairState = stairState;
    }

    public static Stair of(final StairState stairState) {
        return new Stair(stairState);
    }

    private void validate(final StairState stairState) {
        if (Objects.isNull(stairState)) {
            throw new IllegalArgumentException(ErrorMessage.NULL_VALUE);
        }
    }

    public static Stair createOfFirstPillar() {
        return new Stair(StairState.ofFirstPillar(RandomStairGenerationStrategy.getInstance()));
    }

    public Stair createOfNextPillar() {
        return new Stair(stairState.ofNextPillar(RandomStairGenerationStrategy.getInstance()));
    }

    public Stair createOfLastPillar() {
        return new Stair(stairState.ofLastPillar());
    }

    public boolean isRightLineExist() {
        return stairState.isRightLineExist();
    }

    public int move(final int position) {
        return stairState.move(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stair)) return false;
        Stair stair = (Stair) o;
        return stairState == stair.stairState;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stairState);
    }
}
