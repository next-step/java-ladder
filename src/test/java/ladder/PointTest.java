package ladder;

import ladder.domain.Direction;
import ladder.domain.Link;
import ladder.domain.Point;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PointTest {
    @Test
    void When_New_Then_Create() {
        assertDoesNotThrow(() -> {
            new Point(0, Direction.first(Link.CLOSE));
        });
    }

    @Test
    void Given_OpenCloseDirection_When_Move_Then_MoveRight() {
        Point point = new Point(1, Direction.first(Link.CLOSE));
        assertThat(point.move()).isEqualTo(2);
    }

    @Test
    void Given_OpenOpenDirection_When_Move_Then_MoveStraight() {
        Point point = new Point(1, Direction.first(Link.OPEN));
        assertThat(point.move()).isEqualTo(1);
    }

    @Test
    void Given_CloseOpenDirection_When_Move_Then_MoveLeft() {
        Point point = new Point(1, Direction.of(Link.CLOSE, Link.OPEN));
        assertThat(point.move()).isEqualTo(0);
    }

    @Test
    void When_First_Then_NoException() {
        assertDoesNotThrow(() -> {
            Point.first(Link.OPEN);
        });
    }

    @Test
    void When_Next_Then_NoException() {
        assertDoesNotThrow(() -> {
            Point.first(Link.OPEN).next(Link.CLOSE);
        });
    }

    @Test
    void When_Last_Then_NoException() {
        assertDoesNotThrow(() -> {
            Point.first(Link.OPEN).last();
        });
    }
}
