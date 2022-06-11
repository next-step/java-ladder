package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    @DisplayName("Point 생성 결과 테스트")
    void line() {
        Point point = new Point();

        assertThat(point.next(()->true))
                .isEqualTo(new Point(true));
        assertThat(point.next(()->false))
                .isEqualTo(new Point(false));
    }
}