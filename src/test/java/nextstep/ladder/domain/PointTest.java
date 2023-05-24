package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PointTest {


    @DisplayName("index가 1일때, 이전값이 true이고 현재 값이 false이면 0를 반환한다.")
    @Test
    void name() {
        Point point = new Point(1, true, false);
        assertThat(point.move()).isEqualTo(0);
    }

    @DisplayName("index가 1일때, 이전값이 false 현재 값이 true이면 2를 반환한다.")
    @Test
    void name1() {
        Point point = new Point(1, false, true);
        assertThat(point.move()).isEqualTo(0);
    }

    @DisplayName("index가 1일때, 이전값이 false이고 현재 값이 false이면 1를 반환한다.")
    @Test
    void name2() {
        Point point = new Point(1, false, false);
        assertThat(point.move()).isEqualTo(1);
    }

    @DisplayName("index가 1일때, 이전값이 true이고 현재 값이 true이면 예외를 발생한다.")
    @Test
    void name3() {
        assertThatThrownBy(() -> new Point(1, true, true))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
