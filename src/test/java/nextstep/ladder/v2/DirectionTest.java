package nextstep.ladder.v2;

import nextstep.ladder.v2.model.Direction;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
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
    void directionDownTest() {
        //given
        int startPosition = 1;
        //when
        int nextPosition = Direction.DOWN.getNextPosition(startPosition);

        //then
        Assertions.assertThat(nextPosition).isEqualTo(1);
    }

    @Test
    @DisplayName("direction - both previous and current point true")
    void directionTest_BothPreviousAndCurrentPointTrue() {
        //given
        boolean previous = true;
        boolean current = true;
        //when
        ThrowableAssert.ThrowingCallable callable = () -> Direction.of(previous, current);

        //then
        Assertions.assertThatThrownBy(callable).isInstanceOf(IllegalArgumentException.class);
    }
}
