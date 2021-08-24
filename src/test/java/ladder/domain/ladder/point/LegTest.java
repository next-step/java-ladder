package ladder.domain.ladder.point;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import ladder.exception.InvalidLegException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LegTest {

    @Test
    void of_invalidLeftAndRightTrue() {
        assertThatThrownBy(() -> Leg.of(true, true))
                .isInstanceOf(InvalidLegException.class);
    }

    @Test
    void direction_down() {
        Leg leg = Leg.of(false, false);
        assertThat(leg.direction()).isEqualTo(Direction.DOWN);
    }

    @Test
    void direction_left() {
        Leg leg = Leg.of(true, false);
        assertThat(leg.direction()).isEqualTo(Direction.LEFT);
    }

    @Test
    void direction_right() {
        Leg leg = Leg.of(false, true);
        assertThat(leg.direction()).isEqualTo(Direction.RIGHT);
    }

    @ParameterizedTest(name = "[{index}] first with right {0} has left equal to false")
    @ValueSource(booleans = {true, false})
    void first_LeftIsFalse(boolean right) {
        Leg first = Leg.first(right);
        assertThat(first.isLeft()).isFalse();
    }

    @ParameterizedTest(name = "[{index}] last with left {0} has right equal to false")
    @ValueSource(booleans = {true, false})
    void last_RightIsFalse(boolean left) {
        Leg leg = Leg.first(left).last();
        assertThat(leg.isRight()).isFalse();
    }

    @ParameterizedTest(name = "[{index}] left is set to previous right when right {0}")
    @ValueSource(booleans = {true, false})
    void next_SetsLeftToPreviousRight(boolean right) {
        Leg leg = Leg.first(false).next(right);
        assertThat(leg.isLeft()).isFalse();
        assertThat(leg.isRight()).isEqualTo(right);
    }

    @Test
    void next_IfLeftIsTrueSetsRightToFalse() {
        Leg leg = Leg.first(true).next(() -> true);
        assertThat(leg.isRight()).isFalse();
        assertThat(leg.isLeft()).isTrue();
    }
}
