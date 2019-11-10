package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test
    @DisplayName("Point의 direction 호출 시 Direction의 int 값이 나오는지 확인한다.")
    void direction() {
        Point point = new Point(Direction.LEFT);

        assertThat(point.direction()).isIn(Direction.values());
    }
}
