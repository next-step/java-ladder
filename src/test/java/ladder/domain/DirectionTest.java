package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.domain.Direction.LADDER_CAN_NOT_BE_CONSECUTIVE;
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
    @DisplayName("right, left가 모두 true이면, throw exception")
    void should_throw_exception_left_and_right_are_true() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Direction(true, true))
                .withMessage(LADDER_CAN_NOT_BE_CONSECUTIVE);
    }

}