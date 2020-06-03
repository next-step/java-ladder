package ladder.domain.ladder;

import ladder.domain.ladder.strategy.RandomStairGenerationStrategy;
import ladder.exception.ErrorMessage;
import ladder.exception.ValueOutOfBoundsException;

import java.util.Objects;

public class Stair {

    static final int FIRST_PILLAR_POSITION = 0;
    private static final int POSITION_GAP = 1;

    private final int position;
    private final StairState state;

    private Stair(final int position, final StairState state) {
        validate(position, state);
        this.position = position;
        this.state = state;
    }

    public static Stair of(final int position, final StairState state) {
        return new Stair(position, state);
    }

    private void validate(final int position, final StairState state) {
        if (position < FIRST_PILLAR_POSITION) {
            throw new ValueOutOfBoundsException(ErrorMessage.REQUIRED_MIN_STAIR_POSITION);
        }
        if (Objects.isNull(state)) {
            throw new IllegalArgumentException(ErrorMessage.NULL_VALUE);
        }
    }

    public static Stair createOfFirstPillar() {
        return new Stair(FIRST_PILLAR_POSITION, StairState.ofFirstPillar(new RandomStairGenerationStrategy()));
    }

    public Stair createOfMiddlePillar() {
        if (isExistLine()) {
            return createWithNoLine();
        }
        return new Stair(position + POSITION_GAP, state.ofMiddlePillar(new RandomStairGenerationStrategy()));
    }

    public Stair createOfLastPillar() {
        return createWithNoLine();
    }

    private Stair createWithNoLine() {
        return new Stair(position + POSITION_GAP, state.ofMiddlePillarWithNoLine());
    }

    public boolean isExistLine() {
        return this.state.isExistLine();
    }
}
