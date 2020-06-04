package ladder.domain.ladder;

import ladder.domain.ladder.strategy.RandomStairGenerationStrategy;
import ladder.exception.ErrorMessage;

import java.util.Objects;

public class Stair {

    private final StairState state;

    private Stair(final StairState state) {
        validate(state);
        this.state = state;
    }

    public static Stair of(final StairState state) {
        return new Stair(state);
    }

    private void validate(final StairState state) {
        if (Objects.isNull(state)) {
            throw new IllegalArgumentException(ErrorMessage.NULL_VALUE);
        }
    }

    public static Stair createOfFirstPillar() {
        return new Stair(StairState.ofFirstPillar(RandomStairGenerationStrategy.getInstance()));
    }

    public Stair createOfNextPillar() {
        return new Stair(state.ofNextPillar(RandomStairGenerationStrategy.getInstance()));
    }

    public Stair createOfLastPillar() {
        return new Stair(state.ofNextPillarWithNoLine());
    }

    public boolean isExistLine() {
        return this.state.isExistLine();
    }
}
