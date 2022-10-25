package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    public void Point_생성() {
        Point point = new Point(true);
        assertThat(point.isExist()).isTrue();
    }
}