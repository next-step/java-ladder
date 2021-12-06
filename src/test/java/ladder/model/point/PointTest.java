package ladder.model.point;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    @DisplayName("캐시 객체를 가져와 객체가 같은 것 확인")
    void pointCacheTest() {
        assertThat(Point.of(true)).isEqualTo(Point.of(true));
        assertThat(Point.of(false)).isEqualTo(Point.of(false));
    }

    @Test
    @DisplayName("선이면 다음 라인은 선이 아닌 것 테스트")
    void afterLineIsTrueNextIsFalseTest() {
        assertThat(Point.of(true).next()).isEqualTo(Point.of(false));
    }
}