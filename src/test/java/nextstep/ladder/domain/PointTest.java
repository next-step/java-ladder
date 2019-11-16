package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class PointTest {
    @Test
    @DisplayName("첫번째 라인에서 생성 할 Point 테스트")
    void firstIndex() {
        assertThat(Point.firstIndex()).isIn(new Point(0, Direction.RIGHT), new Point(0, Direction.BOTTOM));
    }

    @Test
    @DisplayName("Point에서 옆 Line 같은 높이에 대한 Point를 생성한다.")
    void next() {
        Point point = new Point(0, Direction.RIGHT);
        assertThat(point.next(1)).isEqualTo(new Point(1, Direction.LEFT));

        point = new Point(0, Direction.LEFT);
        assertThat(point.next(1)).isEqualTo(new Point(1, Direction.BOTTOM));

        point = new Point(0, Direction.RIGHT);
        assertThat(point.next(3)).isEqualTo(new Point(1, Direction.LEFT));

        point = new Point(0, Direction.BOTTOM);
        assertThat(point.next(3)).isIn(new Point(1, Direction.BOTTOM), new Point(1, Direction.RIGHT));
    }
}
