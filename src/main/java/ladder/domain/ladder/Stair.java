package ladder.domain.ladder;

import ladder.domain.ladder.strategy.RandomStairGenerationStrategy;
import ladder.exception.ErrorMessage;

import java.util.Objects;

public class Stair {

    private final State state;

    private Stair(final State state) {
        validate(state);
        this.state = state;
    }

    public static Stair of(final State state) {
        return new Stair(state);
    }

    private void validate(final State state) {
        if (Objects.isNull(state)) {
            throw new IllegalArgumentException(ErrorMessage.NULL_VALUE);
        }
    }

    public static Stair createOfFirstPillar() {
        return new Stair(State.ofFirstPillar(RandomStairGenerationStrategy.getInstance()));
    }

    public Stair createOfNextPillar() {
        return new Stair(state.ofNextPillar(RandomStairGenerationStrategy.getInstance()));
    }

    public Stair createOfLastPillar() {
        return new Stair(state.ofLastPillar());
    }

    public boolean isExistLine() {
        return state.isExistLine();
    }

    public int move(final int position) {
        return state.move(position);
    }
}
