package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.domain.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class DirectionTest {

    @Test
    @DisplayName("right가 true인 다음 Direction의 left는 true이다.")
    void should_return_next_direction_left() {
        //Give
        Direction direction = new Direction(false, true);

        //When
        Direction next = direction.next();

        //Then
        assertThat(next.isLeft()).isTrue();
    }

    @Test
    @DisplayName("left가 true, right가 false인 direction을 생성한다.")
    void should_return_left_true_right_false() {
        //Give
        Direction direction = first(true).next(false);

        //When & Then
        assertThat(direction).isEqualTo(of(true, false));
    }

    @Test
    @DisplayName("연속된 사다리이면, throw exception")
    void should_throw_exception_left_and_right_are_true() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Direction(true, true))
                .withMessage(LADDER_CAN_NOT_BE_CONSECUTIVE);
    }

}
