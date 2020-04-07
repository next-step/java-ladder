package ladder;

import ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    @DisplayName("연결되어 있는 Point 옆에는 연결되어 있지 않은 Point 가 있어야 한다.")
    public void initTest() {
        Point connectedPoint = Point.of(true);
        assertThat(Point.nextOf(connectedPoint)).isEqualTo(Point.of(false));
    }

    @Test
    @DisplayName("같은 값을 가진 Point 객체는 동일한 메모리 위치에 있어야 한다")
    public void cacheTest() {
        assertThat(Point.of(true) == Point.of(true)).isTrue();
        assertThat(Point.of(false) == Point.of(false)).isTrue();
    }
}
