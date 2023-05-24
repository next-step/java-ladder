package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

class PointTest {


    @DisplayName("index가 1일때, 이전값이 true이고 현재 값이 false이면 0를 반환한다.")
    @Test
    void name() {
        Point point = new Point(0, true, false);
        assertThat(point.move()).isEqualTo(0);
    }
}
