package ladder.domain.ladderline;

import ladder.RandomTestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PointTest {

    @Test
    @DisplayName("시작점 생성을 확인한다")
    void checkStartPoint() {
        Point point = Point.ofStart(RandomTestUtils.TRUE);
        assertFalse(point.isLeft());
        assertTrue(point.isRight());
    }

    @Test
    @DisplayName("2번째점을 생성을 확인한다")
    void checkSecondPoint() {
        Point point = Point.ofStart(RandomTestUtils.TRUE).next(RandomTestUtils.TRUE);
        assertTrue(point.isLeft());
        assertFalse(point.isRight());
    }

    @Test
    @DisplayName("마지막점을 생성을 확인한다")
    void checkEndPoint() {
        Point point = Point.ofStart(RandomTestUtils.TRUE).next(RandomTestUtils.TRUE).ofEnd();
        assertFalse(point.isLeft());
        assertFalse(point.isRight());
    }

    @Test
    @DisplayName("오른쪽으로 움직이는 것을 확인한다")
    void moveRight() {
        Point point = Point.ofStart(RandomTestUtils.TRUE);
        assertThat(point.move().get()).isEqualTo(1);
    }

    @Test
    @DisplayName("안움직이는 것을 확인한다")
    void stay() {
        Point point = Point.ofStart(RandomTestUtils.FALSE);
        assertThat(point.move().get()).isEqualTo(0);
    }

    @Test
    @DisplayName("왼쪽으로 움직이는 것을 확인한다")
    void moveLeft() {
        Point point = Point.ofStart(RandomTestUtils.TRUE).next(RandomTestUtils.TRUE);
        assertThat(point.move().get()).isEqualTo(0);
    }
}
