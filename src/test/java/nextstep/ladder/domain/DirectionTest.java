package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static nextstep.ladder.domain.Direction.*;
import static org.assertj.core.api.Assertions.*;

public class DirectionTest {

    @DisplayName("위치 값을 인자로 받아 다음 위치 값을 반환한다.")
    @Test
    void nextPoint() {
        // given
        int point = 1;

        // when
        int center = CENTER.nextPoint(point);
        int left = LEFT.nextPoint(point);
        int right = RIGHT.nextPoint(point);

        // then
        assertThat(center).isEqualTo(1);
        assertThat(left).isEqualTo(0);
        assertThat(right).isEqualTo(2);
    }
}
