package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    @DisplayName("인접해 있는 가로 이음선에 따른 이음선 생성 테스트")
    void line() {
        Point point = new Point();

        assertThat(point.randomLink(()->true, false, false))
                .isEqualTo(new Point(true));
        assertThat(point.randomLink(()->true, true, false))
                .isEqualTo(new Point(false));
        assertThat(point.randomLink(()->true, false, true))
                .isEqualTo(new Point(false));
        assertThat(point.randomLink(()->false, false, false))
                .isEqualTo(new Point(false));

    }
}