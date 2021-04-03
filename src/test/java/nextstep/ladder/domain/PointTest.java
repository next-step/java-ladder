package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @DisplayName("Point 객체 생성 테스트")
    @Test
    void create_Point_생성테스트() {
        // given
        Point point = Point.of(true);
        // when
        Point expected = Point.of(true);
        // then
        assertThat(point).isEqualTo(expected);
    }
}
