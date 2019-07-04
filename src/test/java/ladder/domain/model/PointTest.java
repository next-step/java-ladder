package ladder.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PointTest {

    @Test
    @DisplayName("포인트의 인덱스를 확인한다")
    void checkPoint() {
        Point point = Point.of(Index.of(0), Direction.of(true, true));
        assertThat(point.getIndex().get()).isEqualTo(0);
    }

    @Test
    @DisplayName("포인트 비교를 확인한다")
    void checkPoint2() {
        Point point = Point.of(Index.of(0), Direction.of(true, true));
        assertTrue(point.isSamePoint(0));
    }

    @Test
    @DisplayName("시작포인트 여부를 확인한다")
    void checkPoint3() {
        Point point = Point.of(Index.of(0), Direction.of(true, true));
        assertThat(point.isStartPoint());
    }

    @Test
    @DisplayName("왼쪽 방향 존재여부를 확인한다")
    void checkPoint4() {
        Point point = Point.of(Index.of(0), Direction.of(true, true));
        assertTrue(point.isLeft());
    }

    @Test
    @DisplayName("오른쪽 방향 존재여부를 확인한다")
    void checkPoint5() {
        Point point = Point.of(Index.of(0), Direction.of(true, true));
        assertTrue(point.isRight());
    }
}
