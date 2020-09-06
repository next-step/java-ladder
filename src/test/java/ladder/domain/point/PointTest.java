package ladder.domain.point;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @DisplayName("첫번째 포인트 생성 테스트")
    @Test
    void createFirstPointTest() {
        Point first = Point.first(() -> false);

        assertThat(first).isEqualTo(Point.first(() -> false));
    }

    @DisplayName("Point 이동 테스트")
    @ParameterizedTest
    @CsvSource({"true, 1", "false,0"})
    void moveTest(boolean strategy, int expect) {
        Point first = Point.first(() -> strategy);

        assertThat(first.move()).isEqualTo(expect);
    }
}