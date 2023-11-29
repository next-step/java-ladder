package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static nextstep.ladder.domain.Direction.*;
import static org.assertj.core.api.Assertions.*;

public class PointTest {

    @DisplayName("위치 값을 인자로 받아 다음 위치 값을 반환한다.")
    @Test
    void move() {
        // given
        Point point = new Point(0, RIGHT);

        // when & then
        assertThat(point.move()).isEqualTo(1);
    }
}
