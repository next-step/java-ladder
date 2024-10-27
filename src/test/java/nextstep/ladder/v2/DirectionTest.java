package nextstep.ladder.v2;

import nextstep.ladder.v2.model.Direction;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DirectionTest {
    @Test
    @DisplayName("direction - RIGHT")
    void directionRightTest() {
        //given
        int startPosition = 0;
        //when
        int nextPosition = Direction.RIGHT.getNextPosition(startPosition);

        //then
        Assertions.assertThat(nextPosition).isEqualTo(1);
    }

    @Test
    @DisplayName("direction - LEFT")
    void directionLeftTest() {
        //given
        int startPosition = 1;
        //when
        int nextPosition = Direction.LEFT.getNextPosition(startPosition);

        //then
        Assertions.assertThat(nextPosition).isEqualTo(0);
    }

    @Test
    @DisplayName("direction - DOWN")
    void directionDonTest() {
        //given
        int startPosition = 1;
        //when
        int nextPosition = Direction.DOWN.getNextPosition(startPosition);

        //then
        Assertions.assertThat(nextPosition).isEqualTo(1);
    }
}
