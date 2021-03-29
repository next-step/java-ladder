package laddarGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PositionTest {

    @DisplayName("포지션이 같으면 동일 선상이다.")
    @Test
    void samePosition() {
        assertEquals(new Position(1), new Position(1));
    }

    @DisplayName("오른쪽으로 이동한다.")
    @Test
    void rightMove() {
        Position position = new Position(1);
        Position rightMovePosition = position.move(Point.of(false), Point.of(true), 4);
        assertEquals(new Position(2), rightMovePosition);
    }

    @DisplayName("왼쪽으로 이동한다.")
    @Test
    void leftMove() {
        Position position = new Position(1);
        Position leftMovePosition = position.move(Point.of(true), Point.of(false), 4);
        assertEquals(new Position(0), leftMovePosition);
    }

    @DisplayName("포지션은 0이상이여야 한다.")
    @Test
    void valid() {
        assertThrows(IllegalArgumentException.class, () -> new Position(-1));
    }
}