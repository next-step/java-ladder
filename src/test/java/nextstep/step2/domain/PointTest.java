package nextstep.step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    void Point가_존재할경우_true를_반환한다() {
        final var point = new Point(true);

        assertThat(point.exist()).isTrue();
    }

}
