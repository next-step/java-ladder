package ladder;

import ladder.domain.Direction;
import ladder.domain.Link;
import ladder.domain.Side;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class DirectionTest {
    @Test
    void When_Of_Then_InstanceCreated() {
        assertDoesNotThrow(() -> {
            Direction.of(Link.OPEN, Link.CLOSE);
        });
    }

    @Test
    void Given_PrevCloseCurrentClose_When_Of_Then_Exception() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Direction.of(Link.CLOSE, Link.CLOSE));
    }

    @Test
    void Given_MoveToLeft_When_Move_Then_Right() {
        Direction direction = Direction.of(Link.OPEN, Link.CLOSE);

        Side moveSide = direction.move();

        assertThat(moveSide).isEqualTo(Side.RIGHT);
    }

    @Test
    void Given_MoveToRight_When_Move_Then_Left() {
        Direction direction = Direction.of(Link.CLOSE, Link.OPEN);

        Side moveSide = direction.move();

        assertThat(moveSide).isEqualTo(Side.LEFT);
    }

    @Test
    void When_First_Then_Created() {
        Direction direction = Direction.first(Link.CLOSE);

        assertThat(direction).isEqualTo(Direction.of(Link.OPEN, Link.CLOSE));
    }

    @Test
    void When_Last_Then_Created() {
        Direction direction = Direction.first(Link.OPEN);

        assertThat(direction.last()).isEqualTo(Direction.of(Link.OPEN, Link.OPEN));
    }

    @Test
    void When_Next_Then_Created() {
        Direction direction = Direction.first(Link.OPEN);

        assertThat(direction.next(Link.CLOSE)).isEqualTo(Direction.of(Link.OPEN, Link.CLOSE));
    }
}
