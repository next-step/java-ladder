package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.domain.Direction;
import ladder.domain.RandomSingleton;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DirectionTest {

    @DisplayName("of로 생성")
    @Test
    public void ofTest() {

        Direction prevDirection = Direction.LEFT;

        Direction direction = Direction.of(prevDirection, true);
        assertEquals(direction, Direction.RIGHT);

        direction = Direction.of(prevDirection, false);
        assertEquals(direction, Direction.NONE);

        prevDirection = Direction.RIGHT;

        for (int i = 0; i < 5; i++) {
            direction = Direction.of(prevDirection, RandomSingleton.nextBoolean());
            assertEquals(direction, Direction.LEFT);
        }
    }

    @DisplayName("leftCorner로 생성")
    @Test
    public void leftCornerTest() {

        Direction direction = Direction.leftCorner(true);
        assertEquals(direction, Direction.RIGHT);

        direction = Direction.leftCorner(false);
        assertEquals(direction, Direction.NONE);
    }

    @DisplayName("rightCorner로 생성")
    @Test
    public void rightCornerTest() {

        Direction direction = Direction.rightCorner(Direction.LEFT);
        assertEquals(direction, Direction.NONE);

        direction = Direction.rightCorner(Direction.NONE);
        assertEquals(direction, Direction.NONE);

        direction = Direction.rightCorner(Direction.RIGHT);
        assertEquals(direction, Direction.LEFT);
    }

    @DisplayName("isRight 테스트")
    @Test
    public void isRightTest() {
        assertFalse(Direction.LEFT.isRight());
        assertFalse(Direction.NONE.isRight());
        assertTrue(Direction.RIGHT.isRight());
    }

    @DisplayName("move 테스트")
    @Test
    public void moveTest() {
        assertEquals(Direction.LEFT.move(), -1);
        assertEquals(Direction.NONE.move(), 0);
        assertEquals(Direction.RIGHT.move(), 1);
    }
}
