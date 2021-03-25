package laddarGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        position.rightMove();
        assertEquals(new Position(2), position);
    }

    @DisplayName("왼쪽으로 이동한다.")
    @Test
    void leftMove() {
        Position position = new Position(1);
        position.leftMove();
        assertEquals(new Position(0), position);
    }
}