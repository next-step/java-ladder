package nextstep.ladders.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PointTest {

    @Test
    @DisplayName("생성 테스트")
    void create() {
        Point expected = new Point(0, Direction.of(true, false));
        Point actual = new Point(0, Direction.of(true, false));
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("오른쪽에 길이있으면 현재 위치 증가")
    void ifThereIsARoadToTheRightTheCurrentPositionIsIncreased() {
        Point point = new Point(0, Direction.of(false, true));
        assertEquals(point.move(), 1);
    }

    @Test
    @DisplayName("왼쪽에 길이있으면 현재 위치 감소")
    void ifThereIsARoadToTheLeftDecreaseTheCurrentPosition() {
        Point point = new Point(2, Direction.of(true, false));
        assertEquals(point.move(), 1);
    }
}
