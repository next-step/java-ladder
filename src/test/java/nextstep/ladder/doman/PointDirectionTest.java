package nextstep.ladder.doman;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointDirectionTest {

    @Test
    void 정상적으로_이전_포인트를_가져오는지() {
        assertThat(new PointDirection(new Point(true)).isHasPrevious()).isTrue();
    }

}
