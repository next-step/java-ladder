package ladder.domain.row;

import ladder.model.row.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {
    @DisplayName("다음 Row의 Right/Left 값에 따라 다음 방향을 반환한다.")
    @Test
    void findDirection() {
        //given
        boolean isNextLeftTrue = false;
        boolean isNextRightTrue = false;

        //when
        Direction direction = Direction.findDirection(isNextLeftTrue, isNextRightTrue);

        //then
        assertThat(direction).isEqualTo(Direction.STAY);
    }
}