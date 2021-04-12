package ladder;

import ladder.domain.Point;
import ladder.domain.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @DisplayName("위치정보를 인자로 받아 인스턴스가 정상적으로 생성된다.")
    @Test
    void create_위치() {
        Point pointIndex = new Point(Position.FIRST);
        assertThat(pointIndex).isEqualTo(new Point(Position.FIRST));
    }

    @DisplayName("첫번째 Point 여부를 반환한다.")
    @Test
    void first() {
        Point point = new Point(Position.FIRST);
        assertThat(point.isFirst()).isTrue();
    }

    @DisplayName("마지막 Point 여부를 반환한다.")
    @Test
    void last() {
        Point point = new Point(Position.LAST);
        assertThat(point.isLast()).isTrue();
    }
}
