package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test
    @DisplayName("Point.first 를 통해 왼쪽으로 갈 수 없는 Point 가 생성된다")
    void first() {
        assertThat(Point.first(FALSE).move()).isEqualTo(0);
        assertThat(Point.first(TRUE).move()).isEqualTo(1);
    }

    @Test
    @DisplayName("Next 를 통해 다음 Point 를 생성 할 수 있다")
    public void next() {
        Point second = Point.first(TRUE).next();
        assertThat(second.move()).isEqualTo(0);
    }
}
