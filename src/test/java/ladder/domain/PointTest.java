package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test
    @DisplayName("Point.first 를 통해 왼쪽으로 갈 수 없는 Point 가 생성된다")
    void first() {
        assertThat(Point.first(false).move()).isEqualTo(0);
    }
}
