package ladder.domain;

import ladder.domain.Direction;
import ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PointTest {
    public static final Point point1 = new Point(1, Direction.RIGHT);
    public static final Point point2 = new Point(2, Direction.LEFT);

    @Test
    @DisplayName("다음 인덱스 위치 테스트")
    void nextTest() {
        assertAll(
                () -> assertThat(point1.next()).isEqualTo(2),
                () -> assertThat(point2.next()).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("방향 바꾸기 테스트")
    void changeDirectionTest() {
        assertThat(
                point1.changeDirection(Direction.LEFT).isDirection(Direction.LEFT)
        ).isTrue();
    }
}
