package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PointTest {
    @Test
    @DisplayName("첫번째 Point의 prev는 false이다.")
    void firstTest() {
        Point point = Point.first(true);
        assertEquals(point.move(), Direction.RIGHT);
    }

    @Test
    @DisplayName("처음이 아닌 Point의 prev는 이전 Point의 current이다.")
    void nextTest() {
        Point point = Point.first(true).next(false);
        assertEquals(point.move(), Direction.LEFT);
    }

    @Test
    @DisplayName("마지막 Point의 current는 false이다.")
    void lastTest() {
        Point point = Point.first(true).next(false).last();
        assertEquals(point.move(), Direction.STAY);
    }

    @Test
    @DisplayName("prev, current가 둘다 true일 수 없다.")
    void validateTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Point.first(true).next(true));
    }

    @Test
    @DisplayName("Left로 움직인다.")
    void leftTest() {
        Point point = Point.first(true).next(false);
        assertEquals(point.move(), Direction.LEFT);
    }

    @Test
    @DisplayName("움직이지 않는다.")
    void stayTest() {
        Point point = Point.first(false).next(false);
        assertEquals(point.move(), Direction.STAY);
    }

    @Test
    @DisplayName("Right로 움직인다.")
    void rightTest() {
        Point point = Point.first(false).next(true);
        assertEquals(point.move(), Direction.RIGHT);
    }

    @Test
    @DisplayName("")
    void canDrawNextTest() {
        Point point = Point.first(false);
        Assertions.assertTrue(point.canDrawNext());
    }


}
